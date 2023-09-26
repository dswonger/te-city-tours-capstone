<template>
  <div class="monuments">
    <h1>Monuments HomePage</h1>
    <p>If you are seeing this, you are authenticated.</p>
  </div>
</template>

<script>
import service from '../services/ServerService'

export default {
  name: "monuments",
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

<style>

</style>