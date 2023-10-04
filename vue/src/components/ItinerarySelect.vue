<template>
<div>
  <select v-model="selectedItinerary">
  <option v-for="itinerary in itineraries" v-bind:key="itinerary.id" >
      {{itinerary.name}}{{itinerary.id}}
  </option>
  

  </select>
  
  
  </div>
</template>

<script>
import service from "../services/ServerService";
export default {
    name: "select",
    data() {
        return {
            selectedItinerary: '',
            itineraries: {},
            selected: ''
            
        }
    },
    created() {
        service.getAllItineraries().then((response) => {
            this.itineraries = response.data;
        });
    }
}
</script>

<style>

</style>