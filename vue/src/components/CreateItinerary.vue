<template>
  <div>
      <!-- <h3>Add Museum</h3>
      <form v-on:submit.prevent="addMuseum">
           Add museum details here -->
          
      <!--    <button>Save</button>
      </form> -->
  </div>
</template>

<script>
import service from '../services/ServerService.js';

export default {
    data() {
        return {
            newItinerary: []
        }
    },
    methods: {
        addItinerary() {
            // call the service function
            service.addItinerary(this.newItinerary).then(
                (response) => {
                    if(response.status == 200) {
                        window.alert('Attraction Added!');
                        this.newItinerary = {};
                        this.$router.push({name: 'map'});
                    }
                }
            );
        }
    }
}
</script>

<style>

</style>