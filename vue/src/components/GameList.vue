<template>
  
    <div>

    <div>
      <table id= "tblGames">
        <thead>
          <tr>
            <!-- <th>Games List</th> -->
          </tr>
          <tr>
            <td>
              <input type="text" id="nameFilter" v-model="search.name"/>
            </td>
          </tr>
        </thead>
      </table>
    </div>

    <div class="test-style">
      <table>
        <tbody>
          <tr class="game" v-for="game in filteredList" v-bind:key="game.name" v-on:click="handleClick(game)">
            
              <td id="single-game"> 
                <router-link v-bind:to="{name: 'GameDetailsPage', params: { gameId: game.gameId} }">
                  {{game.name}} 
                </router-link>
              </td>
            
          </tr>
        </tbody>
      </table>
    </div>

  </div>
</template>

<script>
import GameService from "../services/GameService";
// import AccountService from "../services/AccountService";
// import GameDetails from "../components/GameDetails.vue";

export default {
  name: "game-list",
  // components: GameService,

  data() {
    return {
      games: [],
      search: {
        name: ''
      },

      filter: {
        name: ''
      },
    };
  },

  computed: {
    filteredList() {
      return this.games.filter ((game) => {
        if (game.name.toLowerCase().includes(this.search.name)) {
          return game;
        }
      })
    }
  },
  created() {
    GameService.getGamesForUser().then(response => {
      this.games = response.data
      })
  },
  // methods: {
  //   retrieveGames() {
  //     GameService.getGames().then((response) => {
  //       this.$store.commit("SET_GAMES", response.data);
  //     });
  //   },
    // addGame() {
  //   this.$store.commit("SET_CURRENT_GAME");
  // },
};
</script>

<style></style>
