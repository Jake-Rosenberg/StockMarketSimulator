<template>
  <div>
    <h1>Create Game Form</h1>
    <div id="game-form">
      <game-form></game-form>
    </div>
  </div>
</template>

<script>
import GameForm from "@/components/GameForm";
export default {
  name: "create-game",

  components: {
    GameForm,
  },
};
</script>

<style>
#game-form {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
</style>
