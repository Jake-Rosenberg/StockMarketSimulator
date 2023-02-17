package com.techelevator.model;

import javax.validation.Valid;

public class GameDTO {

    @Valid
    private Game game;
    private Integer[] userIds;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Integer[] getUserIds() {
        return userIds;
    }

    public void setUserIds(Integer[] userIds) {
        this.userIds = userIds;
    }




}
