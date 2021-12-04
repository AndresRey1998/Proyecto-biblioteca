<template>
  <div class="submit-form mt-10 mx-auto">
    <p class="headline">Add a new user</p>

    <div v-if="!submitted">
      <v-form ref="form" lazy-validation>
        <v-text-field
          v-model="user.userName"
          :rules="[(v) => !!v || 'Username is required']"
          label="Username"
          required
        ></v-text-field>

        <v-text-field
          v-model="user.email"
          :rules="[(v) => !!v || 'Email is required']"
          label="Email"
          required
        ></v-text-field>

      </v-form>

      <v-btn color="primary" class="mt-3" @click="saveUser">Submit</v-btn>
    </div>

    <div v-else>
      <v-card class="mx-auto">
        <v-card-title>
          Submitted successfully!
        </v-card-title>

        <v-card-subtitle>
          Click the button to add new user.
        </v-card-subtitle>

        <v-card-actions>
          <v-btn color="success" @click="newUser">Add</v-btn>
        </v-card-actions>
      </v-card>
    </div>
  </div>
</template>

<script>
import UserDataService from "../services/userData.service";

export default {
  name: "add-user",
  data() {
    return {
      user: {
        id: null,
        userName: "",
        email: "",
      },
    };
  },
  methods: {
    saveUser() {
      var data = {
        title: this.user.title,
        description: this.user.description,
      };

      UserDataService.create(data)
        .then((response) => {
          this.user.id = response.data.id;
          console.log(response.data);
          this.submitted = true;
        })
        .catch((e) => {
          console.log(e);
        });
    },

    newUser() {
      this.submitted = false;
      this.user = {};
    },
  },
};
</script>

<style>
.submit-form {
  max-width: 600px;
}
</style>