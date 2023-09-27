<template>
  <itinerary-map></itinerary-map>
</template>

<script>
import ItineraryMap from '../components/ItineraryMap.vue'


export default {
  name: 'Map',
  components: {
    ItineraryMap
    
  }
}
</script>

<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
