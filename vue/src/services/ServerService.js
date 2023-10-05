import axios from "axios";

export default {

    getAllMonuments() {
        return axios.get(`/allMonuments`);
    },

    addMonument(monument) {
        return axios.post(`/addMonument`, monument);
    },

    deleteMonument(id) {
        return axios.delete(`/Monument/${id}`);
    },

    getAllMuseums() {
        return axios.get(`/allMuseums`);
    },

    addMuseum(museum) {
        return axios.post(`/addMuseum`, museum);
    },

    deleteMuseum(id) {
        return axios.delete(`/Museum/${id}`);
    },
    // these need to be updated with the backend endpoints

    //  getAttractions() {
    //      return axios.get(``)
    //  }
    findIdByUsername(username) {
        return axios.get(`/userId/${username}`)
    },
    addReview(review) {
        return axios.get('/addReview', review)
    },
    addAttractionToList(itineraryId, attractionId) {
        return axios.put(`/itinerary/${itineraryId}/addAttraction/${attractionId}`)
    },
    removeAttractionFromList(itineraryId, attractionId) {
        return axios.delete(`/itinerary/${itineraryId}/removeAttraction/${attractionId}`)
    },




    // Itinerary
    getAllItineraries(){
        return axios.get(`/itinerary/getAll`)
    },
    createItinerary(newItinerary) {
    return axios.post(`/itinerary/create`, newItinerary);
    },
    getItinerary(id) {
        return axios.get(`/itinerary/${id}`)
    },
    deleteItinerary(id) {
        return axios.delete(`/itinerary/delete/${id}`)
    }
}