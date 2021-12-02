<template>
  <div v-if="currentUser" class="edit-form py-3">
    <p class="headline">Edit User</p>

    <v-form ref="form" lazy-validation>
      <v-text-field
        v-model="currentUser.title"
        :rules="[(v) => !!v || 'Title is required']"
        label="Title"
        required
      ></v-text-field>

      <v-text-field
        v-model="currentUser.description"
        :rules="[(v) => !!v || 'Description is required']"
        label="Description"
        required
      ></v-text-field>

      <label><strong>Status:</strong></label>
      {{ currentUser.published ? "Published" : "Pending" }}

      <v-divider class="my-5"></v-divider>

      <v-btn v-if="currentUser.published"
        @click="updatePublished(false)"
        color="primary" small class="mr-2"
      >
        UnPublish
      </v-btn>

      <v-btn v-else
        @click="updatePublished(true)"
        color="primary" small class="mr-2"
      >
        Publish
      </v-btn>

      <v-btn color="error" small class="mr-2" @click="deleteTutorial">
        Delete
      </v-btn>

      <v-btn color="success" small @click="updateTutorial">
        Update
      </v-btn>
    </v-form>

    <p class="mt-3">{{ message }}</p>
  </div>

  <div v-else>
    <p>Please click on a user...</p>
  </div>
</template>

<script>
import UserDataService from "../services/userData.service";

export default {
  name: "user",
  data() {
    return {
      currentUser: null,
      message: "",
    };
  },
  methods: {
    getUser(id) {
      UserDataService.get(id)
        .then((response) => {
          this.currentUser = response.data;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    updatePublished(status) {
      var data = {
        id: this.currentUser.id,
        title: this.currentUser.title,
        description: this.currentUser.description,
        published: status,
      };

      UserDataService.update(this.currentUser.id, data)
        .then((response) => {
          this.currentUser.published = status;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    updateTutorial() {
      UserDataService.update(this.currentUser.id, this.currentUser)
        .then((response) => {
          console.log(response.data);
          this.message = "The user was updated successfully!";
        })
        .catch((e) => {
          console.log(e);
        });
    },

    deleteTutorial() {
      UserDataService.delete(this.currentUser.id)
        .then((response) => {
          console.log(response.data);
          this.$router.push({ name: "tutorials" });
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
  mounted() {
    this.message = "";
    this.getUser(this.$route.params.id);
  },
};
</script>

<style>
.edit-form {
  max-width: 300px;
  margin: auto;
}
</style>