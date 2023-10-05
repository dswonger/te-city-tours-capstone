<template>
<div class="background">
  <container class="container">
    <h1>Monuments Page</h1>
  <p>Select Itinerary to Update</p>

    <itinerary-select></itinerary-select>
  </container>
  <form v-on:submit.prevent="updateItinerary">
    <div class="monuments">
      <div>
    
      <div
        class="monumentCard"
        v-for="monument in monumentsList"
        v-bind:key="monument.id"
      >
        <h3>{{ monument.name }}</h3>
        <p>{{ monument.description }}</p>
        <p>{{monument.address}}</p>
        <img v-bind:src="monument.image" />
        <p>Rating: {{ monument.rate }}</p>

        <div>
          <button
            type="button"
            v-bind:id="monument.id"
            value="Add to Itinerary"
            unchecked
            @click="addAttractionToList"
          >Add to Itinerary</button>

            <button
            type="button"
            id="monumentName"
            value="Remove from Itinerary"
            unchecked
            @click="deleteAttractionFromList"
          >Remove from Itinerary</button>
        </div>
      </div>
           <button type="submit" v-if="$store.state.token != ''">
          View Itinerary!
        </button>
      {{ filteredList }}
    </div>
    </div>
  </form>
  </div>
</template>

<script>
import ItinerarySelect from '../components/ItinerarySelect.vue';
import service from "../services/ServerService";

export default {
  name: "monuments",
  components: {
    ItinerarySelect
   
  },
  data() {
    return {
      monumentsList: [],
      filteredList: [],
      itineraryId: '',
      monumentId: ''
    };
  },
  created() {
    service.getAllMonuments().then((response) => {
      this.monumentsList = response.data;
    });
  },
  methods: {
    addAttractionToList(event){
      let itineraryId = this.$store.state.currentItineraryId
      service.addAttractionToList(itineraryId, event.target.id)
        .then((response) => {
          if (response.status === 200) {
            window.alert('Monument Added!');
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

    deleteAttractionFromList(){
      service.removeAttractionFromList(this.itinerary, this.monumentId)
        .then((response) => {
          if (response === 200) {
            window.alert('Monument Removed!');
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
    filterMonuments(monumentName, monumentAddress) {
      this.filteredList.push(monumentName, monumentAddress);
    },
    // addToItinerary() {
    //this.filteredList.monumentArray = monumentArray;
    // this.$store.commit("ADD_ITINERARY", this.filteredList)
    // }
    // newItineraryMethod(date, text) {
    //   this.newItinerary.push(date, text)
    // },
    // createItinerary() {
    //   service
    //     .createItinerary(this.newItinerary)
    //     .then((response) => {
    //       if (response.status === 200) {
    //         window.alert('Itinerary Created');
            
    //       }
    //     })
    //     .catch((error) => {
    //       if (error.response) {
    //         window.alert("Bad Request");
    //       } else if (error.request) {
    //         window.alert("Could not reach service");
    //       }
    //     });
    // },
    
  } 
};
</script>

<style scoped>
div.monumentCard {
    border: 1px 0A3161;
    background-color: white;
    border-radius: 6px;
    padding: 1rem;
    margin: 20px;
    font: 12pt sans-serif;
    
}
img {
  height: 100px;
}

h1 {
  text-align: center;
  color: white;
  padding-top: 50px;

}

.background {
position: absolute;
top: 0;
left: 0;
background-color:  #B31942; 
z-index: -1;  
}


</style>
