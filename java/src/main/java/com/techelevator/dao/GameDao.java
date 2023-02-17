package com.techelevator.dao;

import com.techelevator.model.Game;
import com.techelevator.model.GameSummary;
import com.techelevator.model.PlayerDTO;

import java.time.LocalDate;
import java.util.List;

public interface GameDao {
    List<Game> getAllGames();
    List<Game> getAllGamesByUserId(int userId);
    Game getGameByGameId(int id);
    GameSummary getGameSummary(int id, String username);
    Game createGame(String name, LocalDate startDate, LocalDate endDate);
    List<PlayerDTO> getLeaderboard(int gameId);


}
