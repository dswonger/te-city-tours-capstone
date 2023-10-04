<template>
<div>
      <form v-on:submit.prevent="createItinerary">
          <div>
        <input
          v-model="newItinerary.date"
          type="date"
          id="itineraryDate"
          value="itineraryDate"
        />Choose the Date for Your Itinerary
        <div>
          <input
            v-model="newItinerary.name"
            type="text"
            id="itineraryName"
            value="iteneraryName"
          />Name Your Itinerary
        </div>

        <button type="submit" v-if="$store.state.token != ''">
          Create Itinerary!
        </button>
        </div>
      </form>
      You must be logged in to create an itinerary.
      </div>
</template>

<script>
import service from '../services/ServerService.js';

export default {
    data() {
        return {
            newItinerary: {}
        }
    },
    methods: {
        createItinerary() {
      service
        .createItinerary(this.newItinerary)
        .then((response) => {
          if (response.status === 200) {
            window.alert('Itinerary Created');
            
          }
        })
        .catch((error) => {
          if (error.response) {
            window.alert("Bad Request");
          } else if (error.request) {
            window.alert("Could not reach service");
          }
        });
    },
        }
    }

</script>

<style>

</style>