<template>
  <div id="login" class="text-center">
    <link rel="stylesheet" href="" />
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >
        Thank you for registering, please sign in.
      </div>
      <label for="username" id="username" class="sr-only">Username:</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" id="password" class="sr-only">Password:</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <router-link :to="{ name: 'Register' }" id="need-account"
        >Need an account?</router-link
      >
      <button class="btn" type="submit">Sign in</button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css?family=Open+Sans&display=swap");
h1 {
  font-family: "Open-Sans", sans-serif;
  display: flex;
  text-align: center;
}

.text-center {
  background: white;
  width: 400px;
  height: 400px;
  border-radius: 6px;
  margin: 20% 25% 20% 35%;
  padding: 0px 0px 70px 0px;
  border: #2980b9 3px solid;
  border-radius: 5%;
}
input[type="text"] {
  align-items: center;
  padding: 10px;
  margin: 10px, 0;
  border: 0;
  box-shadow: 0 0 15px 4px rgba(0, 0, 0, 0.06);
  border-radius: 10px;
}
input[type="text"]:hover {
  background-color: lavender;
  border-color: #000;
}

input[type="password"] {
  padding: 10px;
  margin: 10px, 0;
  border: 0;
  box-shadow: 0 0 15px 4px rgba(0, 0, 0, 0.06);
  border-radius: 10px;
}

input[type="password"]:hover {
  background-color: lavender;
  border-color: #000;
}

h1 {
  display: flex;
  flex-direction: column;
  justify-content: center;
  text-align: center;
}

#username {
  font-family: "Open-Sans", sans-serif;
  text-align: justify;

  margin: 10px;
}

#password {
  font-family: "Open-Sans" sans-serif;
  align-items: left;
  margin: 10px;
}

#need-account {
  display: grid;
  text-align: justify;
  vertical-align: middle;
}

.btn {
  padding: 10px;
  border: none;
  background-color: #7f5a83;
  color: #fff;
  font-weight: 600;
  border-radius: 5px;
  align-items: center;

  margin-top: 10px;
  width: 50%;
}
form.form-signin {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
</style>
