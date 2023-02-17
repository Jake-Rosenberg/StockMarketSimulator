<template>
    <div class="game-details-container">
        <div>
            <game-details v-bind:gameId="$route.params.gameId"/>
        </div>
        <div>
            <leaderboard v-bind:gameId="$route.params.gameId"/>
        </div>
    </div>
</template>

<script>
import GameDetails from "../components/GameDetails.vue"
import Leaderboard from "../components/Leaderboard.vue"
export default {

    components: {
        GameDetails,
        Leaderboard
    },
    
    data() {
        return {
            gameId: ''
        };
    },
    created () {
        this.gameId = parseInt(this.$route.params.gameId);
        this.$store.commit("SET_ACTIVE_GAME", this.gameId);
    }
};
</script>

<style>
.game-details-container {
    display: flex;
    width: 100%;
    /* flex-direction: row; */
    justify-content: space-evenly;
    align-content: center;
}
</style>