<template>

  <div>

    <div>
      <table id= "tblUsers">
        <thead>
          <tr>
            <th>Username</th>
          </tr>
          <tr>
            <td>
              <input type="text" id="usernameFilter" v-model="search.username"/>
            </td>
          </tr>
        </thead>
      </table>
    </div>

    <div class="test-style">
      <table>
        <tbody>
          <tr class="user" v-for="user in filteredList" v-bind:key="user.username" v-on:click="handleClick(user)">
            <td><input type="checkbox" v-bind:username="user.username" v-bind:value="user.id" v-model="selectedUsers"/></td>
            <td id="single-user">{{user.username}}</td>
          </tr>
        </tbody>
      </table>
    </div>

  </div>
</template>

<script>

import UserService from "../services/UserService";

export default {
  name: "user-list",
    data() {
        return {
          // users: UserService.getAllUsers().then(response => {console.log(response.data)}),
          users: [],
          search: {
            username: ''
          },
          filter: {
            username: ''
          },
          selectedUsers: []
        };
    },
    computed: {
      filteredList() {
        return this.users.filter ((user) => {
          if (user.username.toLowerCase().includes(this.search.username)) {
            return user;
          }
        })
      }
    },
    created() {
      UserService.getAllUsers().then( resp => {
        this.users = resp.data;
      })
    },
    methods: {
      handleClick(user) {
        console.log(user.username);
      },
      addSelectedUsers() {
        for (let i = 0; i < this.selectedUsers.length; i++) {
          const user = this.users.find ( (user) => {
            return user.id == this.selectedUsers[i].id;
          });
          user.isParticipant = 'Active';
        }
        this.selectedUsers = [];
      },
      getSelectedUsers() {
        return this.selectedUsers;
      }
    },
    watch: {
      selectedUsers(newValue, oldValue) {
        if (newValue != oldValue) {
          // console.log('selected users changed')
          this.$store.commit('SET_USERS', this.selectedUsers)
        }
      }
    }
}
</script>

<style>

.test-style {
  height: 200px;
  overflow-y: auto;
  overflow-x: hidden;
}

</style>