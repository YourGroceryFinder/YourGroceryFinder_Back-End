<template>
  <ul>
    <li><a class="active" href="#home">Home</a></li>
    <li v-if="!isAuthenticated && !isLoading" style="float:right"><a @click.prevent="login">Log in</a></li>
    <li v-if="isAuthenticated" style="float:right"><a @click.prevent="logout">Log Out</a></li>
  </ul>
</template>

<script>
import { useAuth0 } from '@auth0/auth0-vue';

export default {
  name: "NavBar",
  setup() {
    const auth0 = useAuth0();

    return {
      isAuthenticated: auth0.isAuthenticated,
      isLoading: auth0.isLoading,
      user: auth0.user,
      login() {
        auth0.loginWithRedirect();
      },
      logout() {
        auth0.logout({
          logoutParams: {
            returnTo: window.location.origin
          }
        });
      }
    }
  }
}
</script>

<style scoped>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
  color: white;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #04AA6D;
}
</style>