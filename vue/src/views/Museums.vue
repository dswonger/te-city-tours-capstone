<template>
<div>
   <h1>Museums Page</h1>
     <p>Select Itinerary to Update</p>

<itinerary-select></itinerary-select>

<form v-on:submit.prevent="submitMuseums">

  
  <div class="monuments">
    <div class="background">

   
    
    <div class="museumCard" 
    v-for="museum in museumsList" 
    v-bind:key="museum.id"
    >
        <h3>{{museum.name}}</h3> 
        <p>{{museum.description}}</p>
        <img v-bind:src=" museum.image"/> 
        <p>Rating: {{museum.rate}}</p>

        <div><input type="radio" name="museumName" value="museumId" 
        unchecked @change="filterMuseums(museum.id)">Add to Itinerary</div>
       
        </div>
           <button type="submit" v-if="$store.state.token != ''">
          Update Itinerary!
        </button>
      {{filteredList}}
  </div>
  </div>
  </form>
  </div>
</template>

<script>
import service from '../services/ServerService'
import ItinerarySelect from '../components/ItinerarySelect.vue';
export default {
  name: "museums",
  components: {
    ItinerarySelect
  },
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
      filterMuseums(museumId) {
        this.filteredList.push(museumId)
      },
      
    submitMuseums(filteredList) {
      service.updateItinerary(filteredList).then(
        (response) => {
          if (response.status === 200) {
            window.alert('Itinerary Updated!');
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

