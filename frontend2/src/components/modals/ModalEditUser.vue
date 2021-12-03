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
      :rules="nameRules"
      label="Username"
      required
    ></v-text-field>

    <v-text-field
      v-model="email"
      :rules="emailRules"
      label="Email"
      required
    ></v-text-field>

   <v-checkbox
      v-model="checkbox"
      color="indigo darken-3"
      :label="`Administrator permissions`"
    ></v-checkbox>
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
      >
        Cancel
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
import UserDataService from "../../services/userData.service";

export default {
    async setup(){

    },

    props:{
      id: Number,
      username: String,
      email: String,
      roles: String
    },
    methods:{
      editUser() {
      UserDataService.updateUser(this.props)
        .then((response) => {
          console.log(response.data);
        }).catch((e) => {
          console.log(e);
      });
      
  
    },
  }
}

</script>

<style>

</style>