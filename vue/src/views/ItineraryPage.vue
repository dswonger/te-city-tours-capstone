<template>
<div>
  <div class="background">
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
  color: white;
  margin-top: 60px;
}


.background {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100vh;
  background-color: white; 
  z-index: -1; 
  }
</style>
