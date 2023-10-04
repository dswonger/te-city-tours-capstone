<template>
  <div class="home">
    <h1>Welcome to Washington DC</h1>
<create-itinerary></create-itinerary>
    
        
  </div>
</template>

<script>
import CreateItinerary from '../components/CreateItinerary.vue';
import service from '../services/ServerService'

export default {
  components: { CreateItinerary },
  name: "home",
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

</style>
