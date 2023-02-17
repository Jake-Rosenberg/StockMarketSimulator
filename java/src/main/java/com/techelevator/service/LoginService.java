package com.techelevator.service;

import com.techelevator.dao.GameDao;
import com.techelevator.model.Game;
import com.techelevator.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class LoginService {

    private final GameDao gameDao;

    public LoginService(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    public void haveGamesEnded(User user) {
        List<Game> gameList = gameDao.getAllGamesByUserId(user.getId());
        for (Game game : gameList) {
            if (game.getEndDate().isEqual(LocalDate.now()) || game.getEndDate().isBefore(LocalDate.now())) {
                game.endGame();
            }
        }
    }
}
