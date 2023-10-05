<template>
  <div>
    <h1>My Itinerary</h1>
    <div id="grid-container">

      <!--Google Maps will render map here-->
      <div id="map"></div>


      <div id="input-area">

          <p>For best results the address should have this format: <em>900 10th St NW, Washington, DC 20001</em></p>

          Location to Add: <input v-model="currentInput" type="input"/>
          <button v-on:click="addToList">Add to Route</button>
          
          <p>Current Locations:</p>
          <button v-on:click="generateRoute">Generate Route   <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-compass" viewBox="0 0 16 16">
  <path d="M8 16.016a7.5 7.5 0 0 0 1.962-14.74A1 1 0 0 0 9 0H7a1 1 0 0 0-.962 1.276A7.5 7.5 0 0 0 8 16.016zm6.5-7.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z"/>
  <path d="m6.94 7.44 4.95-2.83-2.83 4.95-4.949 2.83 2.828-4.95z"/>
</svg></button><br><br>
          <div id="currentList" v-for="(location, index) of locations" v-bind:key="index">
              <input class="current-inputs" v-model="locations[index]"/> <button v-on:click="removeFromList(index)">Remove</button>
          </div>
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-compass" viewBox="0 0 16 16">
  <path d="M8 16.016a7.5 7.5 0 0 0 1.962-14.74A1 1 0 0 0 9 0H7a1 1 0 0 0-.962 1.276A7.5 7.5 0 0 0 8 16.016zm6.5-7.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z"/>
  <path d="m6.94 7.44 4.95-2.83-2.83 4.95-4.949 2.83 2.828-4.95z"/>
</svg>
      </div>

      <!--Google Maps will render directions here-->
      <div id="panel"></div>

    </div>
  </div>
</template>

<script >
export default {
  name: "Map",
  props: ['locationsList'],
  created() {
    this.locations = this.locationsList;
  },
  data() {
    return {
      map: null,
      routeService : null,
      routeRendererService: null,
      currentInput : "",
      roundTrip : true,
      mapCenter: { lat: 38.904722, lng: -77.016389 },
      locations: [],
    };
  },

  methods: {
    // This function is called during load, but can also be called to reset the map
    initMap() {

      this.map = new window.google.maps.Map(document.getElementById("map"), {
        center: this.mapCenter,
        zoom: 14,
        maxZoom: 20,
        minZoom: 3,
        streetViewControl: true,
        mapTypeControl: true,
        fullscreenControl: true,
        zoomControl: true,
      });
      let noPOIStyle = [
        {
          featureType: "poi",
          elementType: "labels",
          stylers: [{ visibility: "off" }],
        },
      ];
      this.map.setOptions({ styles: noPOIStyle });
    },

    // This function is called to add a new location
    addToList() {

        if(this.currentInput.trim().length === 0) {
            window.alert("Location cannot be empty");
            return;
        }
        this.locations.push(this.currentInput);
        this.currentInput = "";
    },

    // This function is called to remove a location
    removeFromList(index) {

        if(this.locations.length == 2) {
          window.alert("A start and end location must be present");
          return;
        }

        this.locations.splice(index, 1);
    },

    // This function calls the Google Maps API, renders the route
    // and retrieves the directions
    generateRoute() {

      for(let i=0; i < this.locations.length; i++) {

        if (this.locations[i].trim().length === 0) {
          window.alert("Location cannot be empty");
          return;
        }
      }


      const panel = document.getElementById("panel");
      panel.innerHTML = '';
      this.initMap();

       this.routeService = new window.google.maps.DirectionsService();
       this.routeRendererService = new window.google.maps.DirectionsRenderer();
       
       this.routeRendererService.setMap(this.map);
       this.routeRendererService.setPanel(panel);

      let myWaypoints = [];
      
      /*
        The API expects a single waypoint to be an object like this:
        
        {
          location: "123 somewhere St...",
          stopover: true
        }
      */

      for(let i=1; i < this.locations.length -1; i++) {
        myWaypoints.push( 
          {
            location: this.locations[i],
            stopover: true
          }
        );
      }

       this.routeService.route(
        {
          origin: this.locations[0],
          destination: this.locations[this.locations.length-1],
          waypoints: myWaypoints,
          travelMode: window.google.maps.TravelMode.WALKING,
          avoidTolls: true,
          optimizeWaypoints: true
        }
       ).then(
          (result) => {
            this.routeRendererService.setDirections(result);
          }
       ). catch(
          (error) => {
            console.log(error + "Could not generate route");
          }
       );

    }
  },

  mounted() {
    this.initMap();
  },
};
</script>

<style scoped>

#grid-container {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: 
  "map inputs"
  "directions directions";
}

#map {
  grid-area: map;
  width: 650px;
  height: 400px;
  padding: 25px;
  margin: 25px;
}

#input-area {
  grid-area: inputs;
}

#panel {
  grid-area: directions;
}

.current-inputs {
  width: 350px;
}
</style>