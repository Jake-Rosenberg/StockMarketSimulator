<template>
  <form id="form" v-on:submit.prevent="submitGame">
    <div>
      <label for="name">Game Name:</label>
      <input id="name" name="name" type="text" v-model="game.name" required />
    </div>
    <div id="msg" :class="{ success: !hadError, error: hadError}">
      {{message}}
    </div>
    <div>
      <label for="start-date">Start Date:</label>
      <input id="start-date" name="start-date" type="date" v-model="game.startDate" required/>
    </div>
    <div>
      <label for="end-date">End Date:</label>
      <input id="end-date" name="end-date" type="date" v-model="game.endDate" required/>
    </div>
    <div>
      <h3>Add Users:</h3>
      <div>
        <user-list />
      </div>

    </div>
    <div><input type="submit" /></div>
  </form>
</template>
;
<script>
import GameService from "../services/GameService.js";
import UtilityService from '../services/UtilityService'
import UserList from "./UserList.vue";

export default {
  components: { UserList },
  name: "game-form",
  props: {
    gameID: {
      type: Number,
      default: 0,
    },
  },

  data() {
    return {
      game: {
        name: "",
        startDate: "",
        endDate: "",
      },
      message: '',
      hadError: false
    };
  },

  methods: {
    submitGame() {
      const newGame = {
        gameID: Number(this.$route.params.gameID),
        name: this.game.name,
        startDate: this.game.startDate,
        endDate: this.game.endDate
      };
      if (this.gameID === 0) {
        const gameDto = {
          game: newGame,
          userIds: this.$store.state.selectedUsers
        }
        this.message = '';
        this.hadError = false;
        GameService.createGameWithUserIds(gameDto).then((response) => {
          if (response.status === 201) {
            this.$router.push({name: 'GameDetailsPage', params: {gameId: response.data.gameId}});
          }
        })
        .catch(err => {
          this.message = UtilityService.getValidationErrors(err);
          this.hadError = true;
          // console.log(msg);
        })
      }
    },
  },
};
</script>

<style>

body {
}

h3 {
  text-align: center;
}

/* #form {
  padding: 5%;
  background-color: lightyellow;
  width: 300px;
  height: 400px;
  border: 4px navy solid;
  align-items: center;
  text-align: center;
  padding: 5%;
} */
#form {
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
</style>
