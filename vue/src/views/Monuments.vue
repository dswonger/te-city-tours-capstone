<template>
<form  v-on:submit.prevent="createItinerary"
>
  <div class="monuments">
    <h1>Monuments HomePage</h1>

     <div> <input v-model="newItinerary.date" type="date" id="itineraryDate" value="itineraryDate" >Choose the Date for Your Itinerary
        <div><input v-model="newItinerary.name" type="text" id="itineraryName" value="iteneraryName" >Name Your Itinerary</div>
        
        <button type="submit" v-if="$store.state.token != ''">Create Itinerary!</button></div>
{{newItinerary}}
        <div class="monumentCard" 
        v-for="monument in monumentsList" 
        v-bind:key="monument.id"
        >
        <h3>{{monument.name}}</h3> 
        <p>{{monument.description}} </p>
        <img v-bind:src=" monument.image"/>  
        <p>Rating: {{monument.rate}}</p>

        <div><input type="radio" id="monumentName" value="monumentId" 
         unchecked @change="filterMonuments( monument.id )">Add to Itinerary</div>
        
        </div>
        
       
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
      newItinerary: {},
      
        // date : '',
        // text : ''
       
      
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

    filterMonuments(monumentId) {
      this.filteredList.push(monumentId)
    },
    // newItineraryMethod(date, text) {
    //   this.newItinerary.push(date, text)
    // },
    createItinerary() {
      service.createItinerary(this.newItinerary).then(
        (response) => {
          if (response.status === 200) {
            window.alert('Itinerary Created')
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