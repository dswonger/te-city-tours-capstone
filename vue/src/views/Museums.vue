<template>
<form v-on:submit.prevent="createItinerary">
  <div class="monuments">
    <h1>Museums HomePage</h1>
    
    <div class="museumCard" v-for="museum in museumsList" v-bind:key="museum.id">
        <h3>{{museum.name}}</h3> 
        <p>{{museum.description}}</p>
        <img v-bind:src="'../museumImages/' + museum.image"/> 
        <p>Rating: {{museum.rate}}</p>
        <p><input type="checkbox" name="museumName" value="museumName" unchecked>Add to Itinerary</p>
        <!-- <router-link v-bind:to="{name: 'modify', params: {id: museum.id}}"></router-link> -->
        {{museum.image}}
        </div>
        <button type="submit">Create Itinerary!</button>
  </div>
  </form>
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

<style scoped>
div.museumCard {
    border: 1px black solid;
    border-radius: 6px;
    padding: 1rem;
    margin: 10px;
    font: 12pt sans-serif;
    
}
img {
  height: 100px;
}
</style>