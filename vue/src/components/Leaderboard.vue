<template>
  <div id= "leaderboard-box">
    <h1>Leaderboard for {{game.name}}</h1>
    <div id="box1">
    <table id= "leaderboardTable">
      <thead>
        <tr> <th>Place</th> <th>Username</th> <th>Net Worth</th></tr>
      </thead>
      <tbody>
        <tr v-for="player in leaderboard" v-bind:key="player.accountId"> 
          <td> {{player.place}} </td>
          <td> {{player.username}} </td>
          <td> {{player.netWorth}} </td>
          </tr>
      </tbody>
    </table>
    </div>
  </div>
</template>

<script>

import GameService from "../services/GameService.js"

export default {
  name: "leaderboard",
  props: ['gameId'],

  data() {
    return {
      leaderboard: [],
      game: {}
    }
  },

  created() {
    GameService.getLeaderboard(this.gameId).then((response) => {
      if (response.status == 200) {
        this.leaderboard = response.data;
      }
    });
    GameService.getGame(this.gameId).then((response) => {
      if (response.status == 200) {
        this.game = response.data;
      }
    })
  }

}
</script>

<style>
#leaderboard-box {
  padding: 5%;
  background-color: lightyellow;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 300px;
  height: 400px;
  border: 4px navy solid;
  border-radius: 10px;
  padding: 50px;
  margin: auto;
  margin-top: 60px;
}

.detail-item {
  font-weight: bold;
  padding: 5px;
}

.detail-title {
  font-style: italic;
  color: black;
  padding-right: 5px;
}

#stock-section {
  border: 2px solid black;
  padding: 5px;
}

h1 {
  text-align: center;
  margin: 40px 0 40px;
  text-align: center;
  font-size: 30px;
  color: white;
  /* text-shadow: 2px 2px 4px #000000; */
  font-family: "Cherry Swash", cursive;
}



/* #leaderboardTable{


} */

</style>