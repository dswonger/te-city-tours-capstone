<template>
<form v-on:submit.prevent="createItinerary">
  <div class="monuments">
    <h1>Museums HomePage</h1>
    <p>{If you are seeing this, you are authenticated.}</p>
    <div class="museumCard" v-for="museum in museumsList" v-bind:key="museum.id">
        <p>{{museum.name}}</p> 
        <p>{{museum.museumType}}</p>
        <p>Rating: {{museum.rate}}</p>
        <p><input type="checkbox" name="museumName" value="museumName" unchecked>Add to Itinerary</p>
        <!-- <router-link v-bind:to="{name: 'modify', params: {id: museum.id}}"></router-link> -->
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

<style>
div.museumCard {
    border: 1px black solid;
    border-radius: 6px;
    padding: 1rem;
    margin: 10px;
    
}
</style>