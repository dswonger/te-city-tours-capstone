<template>
<form v-if: 
v-on:submit.prevent="createItinerary()">
  <div class="monuments">
    <h1>Monuments HomePage</h1>
    
        <div class="monumentCard" 
        v-for="monument in monumentsList" 
        v-bind:key="monument.id"
        >
        <h3>{{monument.name}}</h3> 
        <p>{{monument.description}} </p>
        <img v-bind:src=" monument.image"/>  
        <p>Rating: {{monument.rate}}</p>

        <div><input type="checkbox" id="monumentName" value="monumentId" 
         unchecked @change="filterMonuments( monument.id )">Add to Itinerary</div>
        
        </div>
         <div> <input type="date" name="itineraryDate" id="itineraryDate">Choose Date</div>
        <button type="submit" v-if="$store.state.token != ''">Create Itinerary!</button>
      {{filteredList}}
  </div>
  </form>
</template>

<script>
import service from '../services/ServerService'

export default {
  name: "monuments",
  data() {
    return {
      monumentsList : [],
      filteredList: [],
      addIfChecked: false 
    }
  },
  created() {
    service.getAllMonuments().then(
      (response) => {
        this.monumentsList = response.data;
      }
    );
  },
  methods: {
    // filterMonuments() {
    //   if (this.addIfChecked) {
    //     return this.filteredList.filter((monument) => monument.checked);
    //   }else {
    //     return this.filteredList
    //   }
    // },
    filterMonuments(monumentId, itineraryDate, userId) {
      this.filteredList.push(monumentId, itineraryDate, userId)
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
  }
};
</script>

<style scoped>
div.monumentCard {
    border: 1px black solid;
    border-radius: 6px;
    padding: 1rem;
    margin: 10px;
    font: 12pt sans-serif;
    
}
img {
  height: 100px
}
</style>