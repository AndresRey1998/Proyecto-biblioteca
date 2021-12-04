<template>
  <v-layout row wrap>
    <div class="col-md-6">
      <h4>Scientifc article List</h4>
      <ul class="list-group">
        <li
          class="list-group-item"
          :class="{ active: index == currentIndex }"
          v-for="(book, index) in visiblePages"
          :key="index"
          @click="setActiveBook(book, index)"
        >
          {{ book.userName }}
        </li>
      </ul>
    </div>

    <div class="col-md-6">
      <div v-if="currentBook">
        <h4>Book</h4>
        <div>
          <label><strong>Title:</strong></label> {{ currentBook.id }}
        </div>
        <div>
          <label><strong>Description:</strong></label>
          {{ currentBook.userName }}
        </div>
        <div>
          <label><strong>Status:</strong></label>
          {{ currentBook.published ? "Published" : "Pending" }}
        </div>
        <router-link
          :to="'/tutorials/' + currentBook.id"
          class="badge badge-warning"
          >Edit</router-link
        >
      </div>
      <div v-else>
        <br />
        <p>Please click on a book...</p>
      </div>
    </div>
  </v-layout>
  <v-pagination
    v-model="page"
    :length="Math.ceil(books.length / perPage)"
  ></v-pagination>
</template>

<script>
import UserDataService from "../../services/userData.service";

export default {
  name: "scientific-list",
  computed: {
    visiblePages() {
      return this.books.slice(
        (this.page - 1) * this.perPage,
        this.page * this.perPage
      );
    },
  },
  data() {
    return {
      books: [],
      booksPage: [],
      currentBook: null,
      currentIndex: -1,
      perPage: 5,
      page: 1,
      openTab: 1,
    };
  },
  methods: {

    retrieveBooks() {
      UserDataService.getAll()
        .then((response) => {
          this.books = response.data;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    refreshList() {
      this.retrieveBooks();
      this.currentBook = null;
      this.currentIndex = -1;
    },

    setActiveBook(book, index) {
      this.currentBook = book;
      this.currentIndex = book ? index : -1;
    },
  },
  mounted() {
    this.retrieveBooks();
  },
};
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>
