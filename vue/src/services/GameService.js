import axios from "axios";

export default {
  createGame(game) {
    let promise = axios.post('/games/create', game);
    return promise;
  },

  createGameWithUserIds(gameDto) {
    let promise = axios.post('/games', gameDto);
    return promise;
  },

  getGames() {
    return axios.get("/games/");
  },

  getGamesForUser() {
    return axios.get("/me/games/");
  },

  getGame(gameID) {
    return axios.get(`/games/${gameID}`);
  },

  getGameSummary(gameId) {
    return axios.get(`/games/${gameId}/summary`)
  },

  getLeaderboard(gameID) {
    return axios.get(`/games/${gameID}/leaderboard`)
  }
};
