<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter()">{{ stars }}</span>
    {{ rating }} Star Review{{ stars === 1 ? '' : 's' }}
  </div>
</template>

<script>
export default {
  name: "star-summary",
  props: ["rating"],
  methods: {
    updateFilter() {
      this.$store.commit("UPDATE_FILTER", parseInt(this.rating)); //this probably won't work!
    }
  },
  computed: {
    stars() {
      const reviews = this.$store.getters.product.reviews; //or this!
      return reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === parseInt(this.rating) ? 1 : 0);
      }, 0);
    }
  }
};
</script>