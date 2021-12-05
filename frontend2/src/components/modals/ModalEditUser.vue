<template>
  <v-card
    class="mx-auto"
    max-width="344"
    outlined
  >
    <v-list-item three-line>
      <v-list-item-content>
        <div class="text-overline mb-4">
          Editing user...
        </div>
        <v-list-item-title class="text-h5 mb-1">
          Information
        </v-list-item-title>
    <v-form
    ref="form"
    v-model="valid"
    lazy-validation
  >
    <v-text-field
      v-model="username"
      :counter="10"
      label="Username"
      required
    ></v-text-field>

    <v-text-field
      v-model="email"
      label="Email"
      required
    ></v-text-field>
    
<v-layout row wrap>

<v-flex md4 class="lg5-custom">    
  <v-checkbox 
      v-model="roles"
      label="Admin"
      value="ADMIN"
    ></v-checkbox></v-flex>

  <v-flex md4 class="lg5-custom">    
  <v-checkbox 
      v-model="roles"
      label="User"
      value="USER"
    ></v-checkbox></v-flex>
</v-layout>
  </v-form>  
        <v-list-item-subtitle>Warning, It is NOT possible to revert the changes after editing.</v-list-item-subtitle>
      </v-list-item-content>

      <v-list-item-avatar
        tile
        size="80"
        color="grey"
      ></v-list-item-avatar>
    </v-list-item>

    <v-card-actions>
      <v-btn
        outlined
        rounded
        text
        color="success"
        @click="editUser(props)"
      >
            <v-icon left>
        mdi-pencil
      </v-icon>
        Edit
      </v-btn>
           <v-btn
        outlined
        rounded
        text
        color="error"
        @click="closeModalEdit()"
      >
        Cancel
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
import UserDataService from "../../services/userData.service";
import { inject } from 'vue'
import { closeModal } from "jenesius-vue-modal";

export default {
    async setup(){
            const emitter = inject("emitter");

             emitter.emit('refreshEvent')
             

  },
    props:{
      id: Number,
      username: String,
      email: String,
      roles: Array,
      state: Boolean,
    },
  methods:{
    async editUser() {
      this.$swal.fire({
        title: 'Wait a minute',
        html: 'Editing user...',
        allowOutsideClick: false,
        didOpen: () => {
          this.$swal.showLoading()
      }})
        
        await UserDataService.updateUser(this.data())
        .then(() => this.$swal.fire({title: 'Success', icon:'success'})).then(() =>{
          this.$router.go(this.$router.currentRoute)
        })
        .catch((e) =>{
          this.$swal.fire({title: 'Error. Try again.', icon:'error'})
        })
    },

    closeModalEdit(){
      closeModal();
    },
    data: function(){
      return {
        id_current: this.id,
        userName: this.username,
        email: this.email,
        state: this.state,
        roles: this.roles
      }
    },
  }
}

</script>

<style>

</style>