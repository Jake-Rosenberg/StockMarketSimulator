<template>
  <div id="game-detail">
    <!-- <h1>{{ game.name }}</h1>
    <p>{{ game.gameID }}</p>
    <p>GAMEDETAILS</p>
    <p>Balance $ {{account.balance}}</p> -->

    <h1>Game Details</h1>
    <div class="detail-item">
      <span class="detail-title">Name:</span> {{ game.name }}
    </div>
    <div id="stock-section">
      <table id="stock-table">
        <thead>
          <tr>
            <th id="stock-table">Stock</th>
            <th id="stock-table">Basis</th>
            <div></div>
            <th id="stock-table">Current</th>
            <div></div>
            <th id="stock-table">Shares</th>
            <th id="stock-table">Net</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(stock, index) in stockSummaries" :key="index">
            <td id="stock-table">{{ stock.ticker }}</td>
            <td id="stock-table">{{ stock.costBasis }}</td>
            <div></div>
            <td id="stock-table">{{ stock.currentPrice }}</td>
            <div></div>
            <td id="stock-table">{{ stock.shares }}</td>
            <td id="stock-table">{{ stock.net }}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="detail-item">
      <span class="detail-title">Balance:</span> $ {{ summary.balance }}
    </div>
  </div>
</template>

<script>
import GameService from "../services/GameService";
// import AccountService from "../services/AccountService";

export default {
  name: "game-detail",
  props: ["gameId"],
  components: {
    // GameList,
  },
  data() {
    return {
      summary: "",
    };
  },
  methods: {
    getGameSummary() {
      GameService.getGameSummary(this.$route.params.gameId).then((response) => {
        this.$store.commit("SET_ACTIVE_GAME", response.data.game);
        this.summary = response.data;
      });
    },
    /*
    retrieveGame() {
      GameService.getGame(this.$route.params.gameId)
        .then((response) => {
          this.$store.commit("SET_ACTIVE_GAME", response.data);
          AccountService.getAccountsByGameId(this.game.gameId).then((resp) => {
            this.accounts = resp.data;
          });
        })
        .catch((error) => {
          if (error.response && error.response.status === 404) {
            alert(
              "Game not available. This game may have been deleted or you have entered an invalid card ID."
            );
            this.$router.push({ name: "Home" });
          }
        });
    },*/
  },
  created() {
    // this.retrieveGame();
    this.getGameSummary();
  },
  computed: {
    game() {
      return this.$store.state.game;
    },
    account() {
      return this.accounts.length > 0 ? this.accounts[0] : {};
    },
    stockSummaries() {
      return this.summary != ""
        ? this.summary.costBasisList.map((stock) => {
            return {
              ticker: stock.ticker,
              costBasis: stock.costBasis.toFixed(2),
              currentPrice: stock.currentPrice.toFixed(2),
              shares: stock.totalShares,
              net: (stock.currentPrice - stock.costBasis).toFixed(2),
            };
          })
        : [];
    },
  },
};
</script>

<style>
/* two cards - first has the leaderbaords, ordered by balance

game name on second - stocks you have in the game, and current balance

leaderboard is worth of stock + money you have*/

#game-detail {
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

#stock-table {
  border: 1px solid black;
  padding: 5px;
}
</style>
