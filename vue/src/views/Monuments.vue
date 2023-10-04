<template>
<div>
    <h1>Monuments Page</h1>
  <p>Select Itinerary to Update</p>

<itinerary-select></itinerary-select>

  <form v-on:submit.prevent="updateItinerary">
    <div class="monuments">

    
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
          <input
            type="radio"
            id="monumentName"
            value="monumentId"
            unchecked
            @change="filterMonuments(monument.name, monument.address)"
          />Add to Itinerary
        </div>
      </div>
           <button type="submit" v-if="$store.state.token != ''">
          View Itinerary!
        </button>
{{ filteredList }}
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
      active: false
    };
  },
  created() {
    service.getAllMonuments().then((response) => {
      this.monumentsList = response.data;
    });
  },
  methods: {
    // toggle() {
    //   this.active = !this.active
    // },
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
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
  font: 12pt sans-serif;
}
img {
  height: 100px;
}
</style>
