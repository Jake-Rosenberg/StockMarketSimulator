package com.techelevator.dao;

import com.techelevator.model.Game;
import com.techelevator.model.GameSummary;
import com.techelevator.model.PlayerDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcGameDao implements GameDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcGameDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Game> getAllGames() {
        String sql = "SELECT game_id, game_name, start_date, end_date " +
                     "FROM game";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Game> gameList = new ArrayList<>();
        while (results.next()) {
            gameList.add(mapRowToGame(results));
        }
        return gameList;
    }

    @Override
    public List<Game> getAllGamesByUserId(int userId) {
        String sql = "SELECT * FROM game g " +
                "JOIN account a ON g.game_id = a.game_id " +
                "WHERE a.user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        List<Game> gameList = new ArrayList<>();
        while (results.next()) {
            gameList.add(mapRowToGame(results));
        }
        return gameList;
    }

    @Override
    public Game getGameByGameId(int id) {
        String sql = "SELECT game_id, game_name, start_date, end_date " +
                     "FROM game WHERE game_id = ?";
        SqlRowSet gameRow = jdbcTemplate.queryForRowSet(sql,id);
        Game game = null;
        if (gameRow.next()) {
            game = mapRowToGame(gameRow);
        }
        return game;
    }

    @Override
    public GameSummary getGameSummary(int id, String username) {
        String sql = "SELECT g.game_id, game_name, start_date, end_date, account_id, balance\n" +
                "FROM game g\n" +
                "JOIN account a ON  g.game_id = a.game_id\n" +
                "JOIN users u ON a.user_id = u.user_id\n" +
                "WHERE g.game_id = ? AND u.username= ?";
        SqlRowSet gameRow = jdbcTemplate.queryForRowSet(sql,id,username);
        GameSummary summary = null;
        if (gameRow.next()) {
            summary = mapRowToGameSummary(gameRow);
        }
        return summary;
    }

    @Override
    public Game createGame(String name, LocalDate startDate, LocalDate endDate) {
        String sql = "INSERT INTO game (game_name, start_date, end_date) " +
                     "VALUES (?, ?, ?) RETURNING game_id";
        Integer id;
        id = jdbcTemplate.queryForObject(sql, Integer.class, name, startDate, endDate);

        Game game = null;
        if (id != null) {
            String sql2 = "SELECT game_id, game_name, start_date, end_date " +
                          "FROM game WHERE game_id = ? ";
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql2,id);
            if (rowSet.next()) {
                game = mapRowToGame(rowSet);
            }
        }
        return game;
    }

    @Override
    public List<PlayerDTO> getLeaderboard(int gameId) {
        List<PlayerDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM account a " +
                     "JOIN users u ON a.user_id = u.user_id " +
                     "WHERE a.game_id = ? " +
                     "ORDER BY balance DESC, username ASC;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, gameId);
        int place = 1;
        while (rowSet.next()) {
            list.add(mapRowToPlayerDTO(rowSet, place++));
        }
        return list;
    }

    private Game mapRowToGame(SqlRowSet rs) {
        Game game = new Game(
                rs.getInt("game_id"),
                rs.getString("game_name"),
                Objects.requireNonNull(rs.getDate("start_date")).toLocalDate(),
                Objects.requireNonNull(rs.getDate("end_date")).toLocalDate());
        return game;
    }

    private GameSummary mapRowToGameSummary(SqlRowSet rs) {
        Game game = mapRowToGame(rs);
        GameSummary summary = new GameSummary(game, rs.getInt("account_id"),
                rs.getBigDecimal("balance"));
        return summary;
    }

    private PlayerDTO mapRowToPlayerDTO(SqlRowSet rs, int place) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setPlace(place);
        playerDTO.setAccountId(rs.getInt("account_id"));
        playerDTO.setGameId(rs.getInt("game_id"));
        playerDTO.setUserId(rs.getInt("user_id"));
        playerDTO.setUsername(rs.getString("username"));
        //TODO: balance needs to change to net worth when that is done
        playerDTO.setNetWorth(rs.getBigDecimal("balance"));

        return playerDTO;
    }
}
