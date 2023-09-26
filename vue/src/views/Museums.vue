<template>
  <div class="monuments">
    <h1>Museums HomePage</h1>
    <p>If you are seeing this, you are authenticated.</p>
  </div>
</template>

<script>
import service from '../services/ServerService'

export default {
  name: "museums",
  data() {
    return {
      museumsList : []
    }
  },
  created() {
    service.getAllMuseums().then(
      (response) => {
        this.museumsList = response.data;
      }
    );
  }
};
</script>

<style>

</style>