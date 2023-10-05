<template>
<div>
  <select v-model="selectedItinerary" @change="chooseItinerary">
  <option v-for="itinerary in itineraries" v-bind:key="itinerary.id" v-bind:value="itinerary.id" >
      {{itinerary.name}}
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
            console.log(response.data)
            this.itineraries = response.data;
        });
    },
    methods: {
        chooseItinerary(event) {
            this.$store.commit('SET_ACTIVE_ITINERARY', event.target.value)           
        }
    }

}
</script>

<style>

</style>