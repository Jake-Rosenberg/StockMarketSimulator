package com.techelevator.model;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class Game {

    private static final int GAME_NAME_MAX_LENGTH = 20;

    private final int gameId;
    @Size(max = GAME_NAME_MAX_LENGTH, message="Game name must be " + GAME_NAME_MAX_LENGTH + " characters or less.")
    private final String name;
//    @FutureOrPresent(message = "Start date must be today or in the future.")
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Game(int gameId, String name, LocalDate startDate, LocalDate endDate) {
        this.gameId = gameId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getGameId() {
        return gameId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void endGame() {}


}
