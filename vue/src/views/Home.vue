<template>
  <div class="home">
    <h1>Welcome to Washington DC</h1>
    
  </div>
</template>

<script>
import service from '../services/ServerService'

export default {
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
