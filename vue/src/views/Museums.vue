<template>
  <div class="monuments">
    <h1>Museums HomePage</h1>
    <p>{If you are seeing this, you are authenticated.}</p>
    <div class="museumCard" v-for="museum in museumsList" v-bind:key="museum.id">
        <p>{{museum.name}}</p> 
        <p>{{museum.museumType}}</p>
        <p>{{museum.rate}}</p>
        <!-- <router-link v-bind:to="{name: 'modify', params: {id: museum.id}}"></router-link> -->
        </div>
  </div>
</template>

<script>
import service from '../services/ServerService'

export default {
  name: "museums",
  data() {
    return {
      museumsList : []
    }
  },
  created() {
    service.getAllMuseums().then(
      (response) => {
        this.museumsList = response.data;
      }
    );
  }
};
</script>

<style>

</style>