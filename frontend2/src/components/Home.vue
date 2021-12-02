<template>
    <div>
        <p>hola</p>
    </div>
</template>

<script>

// import UserService from "../services/user.service";

export default {
  name: "Home",
  data() {
    return {
      content: "",
    };
  },
  mounted() {
    /*UserService.getPublicContent().then(
      (response) => {
        this.content = response.data;
      },
      (error) => {
        this.content =
          (error.response &&
            error.response.data &&
            error.response.data.message) ||
          error.message ||
          error.toString();
      }
    );*/
  },
};
</script>

<style>
   @import '../assets/css/style.css';
</style>