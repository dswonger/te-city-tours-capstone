<template>
  <div>
    <itinerary-map v-bind:locationsList="getLocations()"/>
  </div>
</template>

<script>
import service from '../services/ServerService';
import ItineraryMap from '../components/ItineraryMap.vue'

export default {
  props: ['itineraryId'],
  name: 'itineraryDetail',
  components: {
    ItineraryMap,
  },
  data() {
    return {
      itinerary: {}
    }
  },
  created() {
    service.getItinerary(this.itineraryId).then(res => this.itinerary = res.data);
  },
  methods: {
    getLocations() {
      const list = this.itinerary.locations;
      console.log("------aaaaaaa--------")
      return list.map(x => x["address"]);
    }
  }
};
</script>

<style scoped>
</style>
