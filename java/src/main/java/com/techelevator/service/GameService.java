package com.techelevator.service;

import com.techelevator.dao.GameDao;
import com.techelevator.model.CostBasis;
import com.techelevator.model.Game;
import com.techelevator.model.GameDTO;
import com.techelevator.model.GameSummary;
import com.techelevator.model.PlayerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Component
public class GameService {

    private final GameDao gameDao;
    private final AccountService accountService;
    private final CostBasisService costBasisService;

    public GameService(GameDao gameDao, AccountService accountService, CostBasisService costBasisService) {
        this.gameDao = gameDao;
        this.accountService = accountService;
        this.costBasisService = costBasisService;
    }

    public List<Game> getAllGames() {
        return gameDao.getAllGames();
    }

    public List<Game> getAllGamesForUser(int userId) {
        return gameDao.getAllGamesByUserId(userId);
    }

    public Game getGameByGameId(int id) {
        return gameDao.getGameByGameId(id);
    }

    public Game createGame(Game newGame) {
        if (newGame.getEndDate().isBefore(newGame.getStartDate()) || newGame.getEndDate().isEqual(newGame.getStartDate())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The end date must be after the start date.");
        }
        return gameDao.createGame(newGame.getName(), newGame.getStartDate(), newGame.getEndDate());
    }

    public Game createGameWithUsers(GameDTO gameDTO) {
        Game newGame = createGame(gameDTO.getGame());
        accountService.createAccountsByGameId(newGame.getGameId(), gameDTO.getUserIds());
        return newGame;
    }

    public List<PlayerDTO> getLeaderboard(int gameId) {
        List<PlayerDTO> leaderboard = gameDao.getLeaderboard(gameId);
        for (PlayerDTO player : leaderboard) {
            List<CostBasis> costBasisList = costBasisService.getAllCostBasisByAccountId(player.getAccountId());
            BigDecimal netWorth = player.getNetWorth();
            for (CostBasis costBasis : costBasisList) {
                netWorth = netWorth.add(costBasis.getCurrentPrice());
            }
            player.setNetWorth(netWorth);
        }
        Collections.sort(leaderboard);
        for (int i = 0; i < leaderboard.size(); i++) {
            leaderboard.get(i).setPlace(i+1);
        }
        return leaderboard;
    }

    public GameSummary getGameSummary(int gameId, String username) {
        GameSummary summary = gameDao.getGameSummary(gameId, username);

        List<CostBasis> costBasisList = costBasisService.getAllCostBasisByAccountId(summary.getAccountId());

        summary.setCostBasisList(costBasisList);

        return  summary;
    }
}
