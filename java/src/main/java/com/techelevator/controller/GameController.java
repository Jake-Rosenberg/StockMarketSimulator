package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.Game;
import com.techelevator.model.GameDTO;
import com.techelevator.model.GameSummary;
import com.techelevator.model.PlayerDTO;
import com.techelevator.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class GameController {

    private final GameService gameService;
    private final UserDao userDao;

    public GameController(GameService gameService, UserDao userDao) {
        this.gameService = gameService;
        this.userDao = userDao;
    }

    @GetMapping("games")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("games/{id}")
    public Game getGameByGameId(@PathVariable int id) {
        return gameService.getGameByGameId(id);
    }

    @PostMapping("games/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@Valid @RequestBody Game newGame) {
        return gameService.createGame(newGame);
    }

    @PostMapping("games")
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGamesWithUsers(@Valid @RequestBody GameDTO gameDTO) {
        return gameService.createGameWithUsers(gameDTO);
    }

    @GetMapping("me/games")
    public List<Game> getCurrentUserGames(Principal currentUser) {
        if (currentUser == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        String name = currentUser.getName();
        return gameService.getAllGamesForUser(userDao.findIdByUsername(name));
    }

    @GetMapping("games/{id}/leaderboard")
    public List<PlayerDTO> getLeaderboard(@PathVariable int id) {
        return gameService.getLeaderboard(id);
    }

    @GetMapping("games/{id}/summary")
    public GameSummary getGameSummary(@PathVariable int id, Principal user) {
        return gameService.getGameSummary(id, user.getName());
    }

}
