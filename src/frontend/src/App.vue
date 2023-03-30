<template>
  <nav-bar />
  <HelloWorld/>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import NavBar from "./components/NavBar.vue";

export default {
  name: 'App',
  components: {
    NavBar,
    HelloWorld
  }
}
</script>