<template>
<div>
  <div class="background">
  <itinerary-map></itinerary-map>
  <create-itinerary></create-itinerary>
  {{newItinerary}}
  </div>
</div>
</template>

<script>
import CreateItinerary from '../components/CreateItinerary.vue'
import ItineraryMap from '../components/ItineraryMap.vue'


export default {
  name: 'Map',
  components: {
    ItineraryMap,
    CreateItinerary,
    
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
  background-color: #white; 
  z-index: -1; 
  }
</style>
