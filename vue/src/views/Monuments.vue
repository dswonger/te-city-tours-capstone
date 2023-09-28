<template>
<form v-on:submit.prevent="createItinerary">
  <div class="monuments">
    <h1>Monuments HomePage</h1>
   
        <div class="monumentCard" v-for="monument in monumentsList" v-bind:key="monument.id">
        <h3>{{monument.name}}</h3> 
        <p>{{monument.description}} </p>
        <img src=({{monument.image}})/>
        <p>Rating: {{monument.rate}}</p>
        <p><input type="checkbox" name="monumentName" value="monumentName" unchecked>Add to Itinerary</p>
        <!-- <router-link v-bind:to="{name: 'modify', params: {id: museum.id}}"></router-link> -->
        </div>
        <button type="submit">Create Itinerary!</button>
  </div>
  </form>
</template>

<script>
import service from '../services/ServerService'

export default {
  name: "monuments",
  data() {
    return {
      monumentsList : []
    }
  },
  created() {
    service.getAllMonuments().then(
      (response) => {
        this.monumentsList = response.data;
      }
    );
  }
};
</script>

<style scoped>
div.monumentCard {
    border: 1px black solid;
    border-radius: 6px;
    padding: 1rem;
    margin: 10px;
    font: 12pt sans-serif;
    
}
img {
  height: 100px
}
</style>