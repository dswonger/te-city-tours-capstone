<template>
  <div class="home">
  <div class="center-container">
  <div class="background">


    <h1>Welcome to Washington DC</h1>
    <h3> Washington, DC, the capital of the United States, is steeped in history and politics. Iconic landmarks like the White House, Capitol, and Washington Monument define its skyline. The city is a cultural hub, boasting world-renowned museums and galleries, particularly the Smithsonian Institution. Whether you're here for business or pleasure, please enjoy your stay in Washington, DC! </h3>
    
  </div>
  </div>
  </div>
</template>

<script>
import service from '../services/ServerService'

export default {
  name: "home",
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

<style scoped>

h1 {
  text-align: center;
  flex-direction: column;
  justify-content: space-between;}

h3{
  text-align: center;
}

.background {
position: absolute;
top: 0;
left: 0;
width: 100%;
height: 200%;
background-color:  #ff0000; 
z-index: -1;  
}


</style>
