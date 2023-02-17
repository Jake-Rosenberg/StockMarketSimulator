<template>
  <div >
    <div id="game-search">
    <h1>Games</h1>

    
  <div id="game-list">
   <game-list />
  </div>
  <div class="buttons">
      <router-link v-bind:to="{ name: 'AddGame' }"
        ><button class="create-btn" role="button">
          Create Game
        </button></router-link>
    </div>
    </div>
  </div>
</template>

<script>
import GameList from "../components/GameList.vue";

export default {
  components: { GameList },
  name: "game",
};
</script>

<style>
/* #game-list {
   display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
} */

#game-search {
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
  margin: auto ;
  margin-top: 60px;
  
  
}
</style>
