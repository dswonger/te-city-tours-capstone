<template>
<div>
  <itinerary-map></itinerary-map>
  <create-itinerary></create-itinerary>
{{newItinerary}} If you see this first, it isn't working.
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
  color: #a8c7e6;
  margin-top: 60px;
}
</style>
