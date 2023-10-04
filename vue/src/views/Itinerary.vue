<template>
  <div>
    <div v-for="itinerary in itineraries" v-bind:key="itinerary.id">
      <h3>{{ itinerary.name }}</h3>
      <p>{{ itinerary.date }}</p>
      <p>----------------------</p>
    </div>
  </div>
</template>

<script>
import service from '../services/ServerService';

export default {
  name: 'itinerary',
  data() {
    return {
      itineraries: {}
    }
  },
  created() {
    service.getAllItinerary().then(res => this.itineraries = res.data);
  },
};
</script>

<style scoped>
</style>
