<template>
<form v-on:submit.prevent="createItinerary()">
  <div class="monuments">
    <div class="background">

    <h1>Museums HomePage</h1>
    
    <div class="museumCard" 
    v-for="museum in museumsList" 
    v-bind:key="museum.id"
    >
        <h3>{{museum.name}}</h3> 
        <p>{{museum.description}}</p>
        <img v-bind:src=" museum.image"/> 
        <p>Rating: {{museum.rate}}</p>

        <div><input type="checkbox" name="museumName" value="museumId" 
        unchecked @change="filterMuseums(museum.id)">Add to Itinerary</div>
       
        </div>
         <div> <input type="date" name="itineraryDate" id="itineraryDate">Choose Date</div>
        <button type="submit" v-if="$store.state.token != ''">Create Itinerary!</button>
      {{filteredList}}
  </div>
  </div>
  </form>
</template>

<script>
import service from '../services/ServerService'

export default {
  name: "museums",
  data() {
    return {
      museumsList : [],
      filteredList: [],
      addIfChecked: false
    }
  },
  created() {
    service.getAllMuseums().then(
      (response) => {
        this.museumsList = response.data;
      }
    );
  },
    methods: {
      filterMuseums(museumId, itineraryDate) {
        this.filteredList.push(museumId, itineraryDate)
      },
      createItinerary() {
      service.createItinerary(this.filteredList).then(
        (response) => {
          if (response.status === 200) {
            this.$router.push(`/itineraryPage`);
          }
        }
      ).catch(
        (error) => {
          if(error.response) {
            window.alert('Bad Request');
          } else if(error.request) {
            window.alert('Could not reach service');
          }
        }
      );
    }
    // submitMuseums() {
    //   service.createItinerary(this.museum).then(
    //     (response) => {
    //       if (response.status === 200) {
    //         this.$router.push(`/itineraryPage`);
    //       }
    //     }
    //   ).catch(
    //     (error) => {
    //       if(error.response) {
    //         window.alert('Bad Request');
    //       } else if(error.request) {
    //         window.alert('Could not reach service');
    //       }
    //     }
    //   );
    // }
  }
};
</script>

<style scoped>
div.museumCard {
    border: 1px black solid;
    background-color: white;
    border-radius: 6px;
    padding: 1rem;
    margin: 20px;
    font: 12pt sans-serif;
    
}
img {
  height: 100px;
}

.background {
  background-color: red;  
}
</style>

