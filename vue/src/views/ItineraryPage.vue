<template>
<div>
  <itinerary-map></itinerary-map>
  <create-itinerary></create-itinerary>
  
{{itineraryList}} If you see this first, it isn't working.
    <div class="itineraryCard"
    v-for="itinerary in itineraryList"
    v-bind:key="itinerary.id">
    <h3>{{itinerary.name}}</h3>
    <p>{{itinerary.date}}</p>
    <p>{{itinerary.locations}}</p>
  </div>
  
  </div>

</template>

<script>
import CreateItinerary from '../components/CreateItinerary.vue'
import ItineraryMap from '../components/ItineraryMap.vue'
import service from '../services/ServerService'

export default {
  name: 'Map',
  components: {
    ItineraryMap,
    CreateItinerary,
  },
  data() {
    return {
      itineraryList : []
    }
  },
  created() {
    service.getAllItineraries().then(
      (response) => {
        this.itineraryList = response.data;
      }
    )
  }
}
</script>

<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #a8c7e6;
  margin-top: 60px;
}
div.itineraryCard {
    border: 1px black solid;
    border-radius: 6px;
    padding: 1rem;
    margin: 10px;
    font: 12pt sans-serif;
    
}
</style>
