<template>
  <div id="app" class="container">
    <div>
      <img
        src=".\assets\stockmarketlogo.jpg"
        alt="jake and anas"
        class="logo"
      />
    </div>
    <div id="nav">
      <div></div>
      <nav>
        <li>
          <router-link
            style="text-decoration: none; color: black"
            v-bind:to="{ name: 'home' }"
            >Home</router-link
          >
        </li>
        <li>
          <router-link
            style="text-decoration: none; color: black"
            v-bind:to="{ name: 'AddTrade' }"
            >Trade</router-link
          >
        </li>
        <li>
          <router-link
            style="text-decoration: none; color: black"
            v-bind:to="{ name: 'Game' }"
            >Games</router-link
          >
        </li>
        <li>
          <router-link
            style="text-decoration: none; color: black"
            v-bind:to="{ name: 'Stock' }"
            >Stocks</router-link
          >
        </li>
        <li>
          <router-link
            style="text-decoration: none; color: black"
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
            >Logout</router-link
          >
        </li>
        <div class="animation start-home"></div>
      </nav>

      <div id="nav-bar">
        <!-- <li><router-link v-bind:to="{ name: 'home' }">Home</router-link></li> -->
        <!-- &nbsp;|&nbsp; -->
      </div>
    </div>
    <router-view />
  </div>
</template>

<style>
@import url("https://fonts.googleapis.com/css?family=Open+Sans&display=swap");
body {
  background-color: #754d9d;
  font-family: "Open Sans", sans-serif;
}

/* #nav {
  display: flex;
  justify-content: space-between;
  font-family: "Open Sans", sans-serif;
}

#nav-bar {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 20px;
} */

.logo {
  display: flex;
  align-items: left;

  height: 150px;
  width: 150px;
}

nav {
  margin: -100px auto 0;
  display: flex;
  justify-content: space-evenly;
  position: relative;

  height: 50px;
  background-color: #c8a2c8;
  border-radius: 8px;
  font-size: 0;
  width: 80%;
  top: 0;
}
nav li {
  line-height: 50px;
  height: 100%;
  font-size: 15px;
  display: inline-block;
  position: relative;
  z-index: 1;
  text-decoration: blanchedalmond;
  text-transform: uppercase;
  text-align: center;
  color: yellow;
  cursor: pointer;
  font-weight: bold;
}
nav .animation {
  position: absolute;
  height: 100%;
  top: 0;
  z-index: 0;
  transition: all 0.5s ease 0s;
  border-radius: 8px;
}
li:nth-child(1) {
  width: 100px;
}
li:nth-child(2) {
  width: 110px;
}
li:nth-child(3) {
  width: 100px;
}
/* a:nth-child(4) {
  width: 160px;
}
a:nth-child(5) {
  width: 120px;
} */
nav .start-home,
li:nth-child(1):hover ~ .animation {
  width: 250px;
  left: 100px;
  background-color: lightyellow;
}
nav .start-trade,
li:nth-child(2):hover ~ .animation {
  width: 250px;
  left: 375px;
  background-color: lightyellow;
}
nav .start-games,
li:nth-child(3):hover ~ .animation {
  width: 250px;
  left: 675px;
  background-color: lightyellow;
}
nav .start-stock,
li:nth-child(4):hover ~ .animation {
  width: 250px;
  left: 925px;
  background-color: lightyellow;
}
nav .start-login,
li:nth-child(5):hover ~ .animation {
  width: 250px;
  left: 1160px;
  background-color: lightyellow;
}
h1 {
  text-align: center;
  margin: 40px 0 40px;
  text-align: center;
  font-size: 30px;
  color: #ecf0f1;
  text-shadow: 2px 2px 4px #000000;
  font-family: "Cherry Swash", cursive;
}

p {
  position: absolute;
  bottom: 20px;
  width: 100%;
  text-align: center;
  color: #ecf0f1;
  font-family: "Cherry Swash", cursive;
  font-size: 16px;
}

span {
  color: #2bd6b4;
}

h2 {
  position: absolute;
  text-align: center;
  bottom: 20px;
  width: 100%;
}
</style>
