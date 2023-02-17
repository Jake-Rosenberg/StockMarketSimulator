<template>
  <form id="tradeForm" class="form" v-on:submit.prevent="submitTrade">
    <div>
      <div id="msg" :class="{ success: !hadError, error: hadError }">
        {{ message }}
      </div>
      <div id="user-game-input">
        <h3>Select Game</h3>
        <div>
          <select
            name="game-choice"
            id="game-choice"
            required
            v-model="selectedGame"
            @change="handleGameChange"
          >
            <option value="">--Please select a game--</option>
            <option
              :value="game.gameId"
              v-for="game in games"
              v-bind:key="game.name"
            >
              {{ game.name }}
            </option>
          </select>

          <!-- <game-list /> -->
        </div>
      </div>
      <div id="form-input">
        <h3>Trade Type:</h3>
        <select
          id="tradeType"
          name="TradeType"
          required
          v-model="trade.tradeType"
        >
          <option value="">--Please select an option--</option>
          <option value="1">Buy</option>
          <option value="2">Sell</option>
        </select>
      </div>
      <div id="form-input">
        <label for="stock-name">Stock Ticker:</label>
        {{ foundStock.ticker }}
        <!-- stock ticker, a dropdown bar of user games -->
        <input
          id="stock-name"
          name="stock-name"
          type="text"
          v-model="searchText"
          v-on:keydown="handleKeyup($event)"
          v-on:blur="updateStockInfo"
        />
      </div>
      <div id="form-input">
        <h3>Number of Shares:</h3>
        <label for="num-shares"></label>
        <input
          id="num-shares"
          name="num-shares"
          type="number"
          min="1"
          v-model="trade.numShares"
          required
        />
      </div>
      <div id="form-input">
        <label for="stock-price">Price:</label>
        {{ foundStock.currentPrice }}
      </div>
      <!-- <div id="form-input">
        <h3>Trade Date:</h3>
        <label for="trade-date"></label>
        <div id="trade-date"></div>
        <input id="trade-date" name="trade-date" type="date" required />
      </div> -->
      <div><input type="submit" :disabled="!allDataPresent" /></div>
    </div>
  </form>
</template>

<!-- method to get account id, trade id, stock price and time without the User input -->

<script>
import TradeService from "../services/TradeService";
// import GameList from "../components/GameList";
import StockService from "../services/StockService";
import GameService from "../services/GameService";
import AccountService from "../services/AccountService";
import UtilityService from "../services/UserService";

export default {
  // components: { GameList },
  name: "trade-form",
  props: {
    tradeId: {
      type: Number,
      default: 0,
    },
  },

  data() {
    return {
      trade: {
        tradeType: "",
        stockId: "",
        accountId: "",
        numShares: "",
        price: "",
        tradeDateTime: "",
      },
      games: {
        name: "",
      },
      searchText: "",
      foundStock: {},
      selectedGame: "",
      message: '',
      hadError: false
    };
  },

  created() {
    GameService.getGamesForUser().then((response) => {
      this.games = response.data;
    });
  },
  computed: {
    allDataPresent() {
      return (
        this.trade.tradeType != "" &&
        this.foundStock &&
        this.foundStock.stockId &&
        this.foundStock.currentPrice &&
        this.trade.accountId != "" &&
        this.trade.numShares != ""
      );
    },
  },
  methods: {
    handleGameChange() {
      this.trade.accountId = "";
      AccountService.getAccountsByGameId(this.selectedGame).then((resp) => {
        const account = resp.data.find(
          (acct) => (acct.userId == this.$store.state.user.id)
        );
        if (account != undefined) {
          this.trade.accountId = account.accountId;
        }
      });
    },
    submitTrade() {
      const newTrade = {
        tradeId: 0,
        tradeTypeId: Number(this.trade.tradeType),
        tradeTypeDesc: this.trade.tradeType == 1 ? "BUY" : "SELL",
        stockId: this.foundStock.stockId,
        accountId: this.trade.accountId,
        numShares: Number(this.trade.numShares),
        price: this.foundStock.currentPrice,
        tradeDateTime: new Date(),
      };

      if (this.tradeId === 0) {
        this.message = '';
        this.hadError = false;
        TradeService.createTrade(newTrade).then((response) => {
          if (response.status === 200) {
            // this.$router.push(`/trades/create, ${newTrade.tradeId}`);
            this.message = 'Trade completed succesfully.';
            this.clearForm();
          }
        })
        .catch(err => {
          this.message = err.response.data;
          this.hadError = true;
        })
      }
    },
    handleKeyup(event) {
      if (event.key === "Enter") {
        event.preventDefault();
        event.stopPropagation();
        this.updateStockInfo();
      }
    },
    updateStockInfo() {
      this.message = '';
      this.hadError = false;
      this.foundStock = {};
      StockService.getStockByTicker(this.searchText).then((response) => {
        this.foundStock = response.data;
      })
      .catch( () => {
        this.message = 'An error occurred.'
        this.hadError = true;
      })
    },
    clearForm() {
        this.selectedGame = ''
        this.searchText = ''
        this.trade.tradeType = '';
        this.foundStock = {};
        this.trade.numShares = '';
    },
    testErrors(data) {
      const msg = UtilityService.getValidationErrors(data);
      return msg;
    }

,

      /*
      tradeId: 0,
        tradeTypeId: Number(this.trade.tradeType),
        tradeTypeDesc: this.trade.tradeType == 1 ? "BUY" : "SELL",
        stockId: this.foundStock.stockId,
        accountId: this.trade.accountId,
        numShares: Number(this.trade.numShares),
        price: this.foundStock.currentPrice,
        tradeDateTime: new Date(),
      */
    // }
  },
};
</script>

<style>
/* body {
} */

h3 {
  text-align: center;
}

#form-input {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

#tradeForm {
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
}
#h4 {
  justify-content: center;
  align-content: center;
}


#msg {
  text-align: center;
}
.error {
  color: red;
}

.success {
  color: green;
}
</style>
