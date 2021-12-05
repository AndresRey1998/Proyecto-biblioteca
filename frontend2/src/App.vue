<template>
<div id="app">
        <nav class="navbar navbar-expand navbar-dark ">
      <a href="/" class="">
      <img class="logo" v-bind:src="require('./assets/img/logo-chikito.png')" alt="HANCOCK BOOKS">
      </a>
      <div class="navbar navbar-nav mr-auto">
        <li class="li nav-item">
          <router-link to="/home" class="nav-link">
            <font-awesome-icon icon="home" /> Home
          </router-link>
        </li>
        <li v-if="showAdminBoard" class="li nav-item">
          <router-link to="/admin" class="nav-link">Audit</router-link>
        </li>
        <li class="li nav-item nav-link" v-if="showAdminBoard">
   <div class="text-center">
      <v-menu offset-y>
        <template v-slot:activator="{ props }">
          <v-btn
            style=" all: unset;"
            v-bind="props"
          >
            Users
          </v-btn>
        </template>
        <v-card
    class="mx-auto"
    max-width="400"
    tile
  >
        <v-list>
            <router-link to="/addUser" class="nav-link">Add</router-link>
            <router-link to="/listUser" class="nav-link">List</router-link>
        </v-list>
          </v-card>

      </v-menu>
      
    </div>
        </li>
       <li class="nav-item nav-link">
   <div class="text-center">
      <v-menu offset-y>
        <template v-slot:activator="{ props }">
          <v-btn
            style=" all: unset;"
            v-bind="props"
          >
            Books
          </v-btn>
        </template>
        <v-card
    class="mx-auto"
    max-width="400"
    tile
  >
        <v-list>
            <router-link to="/addBook" class="nav-link">Add</router-link>
            <router-link to="/listBook" class="nav-link">List</router-link>
        </v-list>
          </v-card>

      </v-menu>
      
    </div>
        </li>
        <li class="li nav-item">
          <router-link v-if="currentUser" to="/user" class="nav-link">History</router-link>
        </li>
      </div>
      <div v-if="!currentUser" class="navbar-nav ml-auto">
        <li class="li nav-item">
          <router-link to="/register" class="nav-link">
            <font-awesome-icon icon="user-plus" />Register
          </router-link>
        </li>
        <li class="li nav-item">
          <router-link to="/login" class="nav-link">
            <font-awesome-icon icon="sign-in-alt" />Log In
          </router-link>
        </li>
      </div>
      <div v-if="currentUser" class="navbar-nav ml-auto">
        <li class="li nav-item">
          <router-link to="/profile" class="nav-link">
            <font-awesome-icon icon="user" />
            {{ currentUser.username }}
          </router-link>
        </li>
        <li class="li nav-item">
          <a class="nav-link" @click.prevent="logOut">
            <font-awesome-icon icon="sign-out-alt" /> Log out
          </a>
        </li>
      </div>
    </nav>
    
    <div class="container">
      <router-view />
    </div>
  </div>
  <Suspense>
  <widget-container-modal />
  </Suspense>
</template>

<script>
import {container} from "jenesius-vue-modal"; 
export default {
  components: {WidgetContainerModal: container},
  name: "App",
  // Gestion de categorias por rol
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
    showAdminBoard() {
      if (this.currentUser && this.currentUser['rol']) {
        return this.currentUser['rol'].includes('ADMIN');
      }

      return false;
    },
  },
  methods: {
    logOut() {
      this.$store.dispatch('auth/logout');
      this.$router.push('/login');
    }
  }
};
</script>

<style scoped>
.fade-enter-active, .fade-leave-active {
  transition: opacity .5s ease;
}
.fade-enter-from, .fade-leave-to {
  opacity: 0;
}
</style>
