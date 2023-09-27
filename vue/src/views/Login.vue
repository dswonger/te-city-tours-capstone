<template>
  <div id="login">
    <div class="center">
    <form class="form-size" @submit.prevent="login">
      <h1>Welcome to City Tours  Washington DC</h1>
      <h1 >Please Sign In</h1>
    
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>

      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>

      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button type="submit">Sign in</button>
      <p>
      <router-link :to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
    </div>
  </div>
</template>


<script scoped>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}
</style>


<style>
#login {
  display: flex;
  justify-content: center;
  margin: auto;
  color: white;
}
.form-size {
  width: 550px;
}

.center {
  display: flex;
  justify-content: center;
}

.my-component {
  background-color: #ffffff;
  padding: 20px;
  border: 1px solid #ccc;
}

.centered-text {
  text-align: center;
}

h1 {
  color: white;
}

p {
  font-size: 16px;
}


</style>

<style>
  .btn {
    padding: 0.8rem 1rem 0.7rem;
    border: 0.2rem solid #5a5a5a;
    cursor: pointer;
    text-transform: capitalize;
  }
  
  .btn-group {
    display: flex;
    justify-content: space-between;
  }
  .btn-group > * {
    flex: 1 1 auto;
  }
  .btn-group > * + * {
    margin-left: 0.8rem;
  }
  .label-wrapper {
    margin: 0;
    flex: 0 0 100%;
    text-align: center;
  }
  [class*="__lg"] {
    display: inline-block;
    width: 100%;
    font-size: 1.9rem;
  }
  
  .visually-hidden {
    position: absolute;
    height: 1px;
    width: 1px;
    overflow: hidden;
    clip: rect(1px 1px 1px 1px);
    clip: rect(1px, 1px, 1px, 1px);
    clip-path: rect(1px, 1px, 1px, 1px);
    white-space: nowrap;
  }
  [class*="stack"] > * {
    margin-top: 0;
    margin-bottom: 0;
  }
  .stack-small > * + * {
    margin-top: 1.25rem;
  }
  .stack-large > * + * {
    margin-top: 2.5rem;
  }
  
  .flex-container {
    display: flex;
    justify-content: center;
    height: 705px;
    width: 564px;
    background-image: url('/src/images/capital2.jpg');
    background-attachment: fixed;
    background-position: center;
    background-repeat: no-repeat;
    margin: auto;
  }

  #app {
    display: flex;
    flex-direction: column;
    justify-content: center;
    margin: 2rem 0 4rem 0;
    position: relative;
    box-shadow:
      0 2px 4px 0 rgba(0, 0, 0, 0.2),
      0 2.5rem 5rem 0 rgba(0, 0, 0, 0.1);
  }

  /* #app > * {
    max-width: 50rem;
    margin-left: auto;
    margin-right: auto;
  }
  #app > form {
    max-width: 100%;
  } */
  #app h1 {
    display: block;
    min-width: 75%;
    width: 75%;
    text-align: center;
    margin: 0;
    margin-bottom: 1rem;
  }
</style>


