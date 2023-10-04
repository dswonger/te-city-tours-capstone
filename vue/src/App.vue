<template>
  <div id="app">
    <nav id="nav">
      <router-link id="link" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;&nbsp;      
      <router-link id="link" v-bind:to="{ name: `museums` }">Museums</router-link>&nbsp;&nbsp;
      <router-link id="link" v-bind:to="{ name: `monuments` }">Monuments</router-link>&nbsp;&nbsp;
      <router-link id="link" v-bind:to="{ name: `map` }" v-if="$store.state.token != ''">My Itinerary</router-link>&nbsp;
      <router-link id="link" v-bind:to="{ name: 'login'}" >Login</router-link>&nbsp;&nbsp;
      <router-link id="link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;&nbsp;
      
    </nav>
    <router-view />
  </div>


</template>

<style>
#nav {
  display: block;
  padding: 8px;
  background-color: #dddddd;
  color: white;
}
#nav link:hover {
  background-color: red;
}

</style>
