<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;&nbsp;      
      <router-link v-bind:to="{ name: `museums` }">Museums</router-link>&nbsp;&nbsp;
      <router-link v-bind:to="{ name: `monuments` }">Monuments</router-link>&nbsp;&nbsp;
      <router-link v-bind:to="{ name: `map` }" v-if="$store.state.token != ''">My Itinerary</router-link>&nbsp;
      <router-link v-bind:to="{ name: 'login'}" >Login</router-link>&nbsp;&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;&nbsp;
      
    </div>
    <router-view />
  </div>
</template>
