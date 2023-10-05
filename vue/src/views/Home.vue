<template>
<main id="main-grid">
  <div class="home">
  <div class="background">
    <h1>Welcome to Washington DC</h1>

    
        
    <h3> Washington, DC, the capital of the United States, is steeped in history and politics. Iconic landmarks like the White House, Capitol, and Washington Monument define its skyline. The city is a cultural hub, boasting world-renowned museums and galleries, particularly the Smithsonian Institution. Whether you're here for business or pleasure, please enjoy your stay in Washington, DC! </h3>
    <div class="image-container">
      <img src="@/images/17.jpg" alt="My Image" />
      <img src="@/images/Cap1arena.jpg" alt="My Image2" />
      <img src="@/images/uscapital.jpg" alt="My Image3" />
      <img src="@/images/image5.jpg" alt="My Image3" />
      <img src="@/images/image6.jpg" alt="My Image3" />
      <img src="@/images/image7.jpg" alt="My Image3" />
    </div> 
    <h2>Check out Washington DC's famous attractions</h2>
    <b-container class =  "image-container">
      <b-col cols="3">
        <a href="http://localhost:8080/allMuseums">
          <b-row>
            <img src="@/images/phot2.jpg" alt="Link Image">
          </b-row>
          <b-row>
            <b-col lg="4" class="pb-2"><b-button size="sm" variant="outline-info">Museums</b-button></b-col>
          </b-row>
        </a>
      </b-col>
      <b-col cols="3">
        <a href="http://localhost:8080/allMonuments">
          <b-row align-v="center">
            <img src="@/images/photo1.jpg" alt="Link Image">
          </b-row>
           <b-row align-v="center">
              <b-col lg="4" class="pb-2"><b-button size="sm" variant="outline-info">Monuments</b-button></b-col>
           </b-row>
        </a>
      </b-col>
    </b-container>
  </div>
  </div>
  </main>
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
  color: white;
  padding-top: 150px;
  flex-direction: column;
  justify-content: space-between;
  grid-area:"welcome";
}

h2 {
  text-align: center;
  color: white;
  padding-top: 100px;
  flex-direction: column;
  justify-content: space-between;
  grid-area:"welcome";
}

.image-container img {
  width: 300px;
  height: 200px;
  /* top: 50%; */
  /* left: 50%; */
  /* transform: translate(-50%, -50%); */
}

.image-container{
  display: flex;
  justify-content: center;
  align-items: center;
  /* height: 100vh; Adjust the height as needed */
}

#main-grid{
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
  "welcome welcome"
  "row2 row2"
  "row3 row3"
  "row4-1 row4-2"
  "row5-1 row5-2";
  align-items: center;

}

h3{
  text-align: center;
  color: white;
  padding-left: 150px;
  padding-right: 150px;
}

.background {
position: absolute;
top: 0;
left: 0;
width: 100%;
height: 100%;
background-color:  #B31942;  
z-index: -1;  
}


</style>
