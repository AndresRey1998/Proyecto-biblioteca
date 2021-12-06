<template>
  <v-layout row wrap>
    <div class="col-md-6">
      <h4>Scientific Article List</h4>
      <ul class="list-group">
        <li
          class="list-group-item"
          :class="{ active: index == currentIndex }"
          v-for="(book, index) in visiblePages"
          :key="index"
          @click="setActiveBook(book, index)"
        >
          {{ book.titleBook }}
        </li>
      </ul>
    </div>

    <div class="col-md-6">
      <div v-if="currentBook">
        <h4>Book details</h4>
        <div>
          <label><strong>ISSN/SSN:</strong></label> {{ currentBook.id }}
        </div>
        <div>
          <label><strong>Title:</strong></label> {{ currentBook.titleBook }}
        </div>
        <div>
          <label><strong>Author/s:</strong></label>
          {{ currentBook.author.name }}
        </div>
        <div>
          <label><strong>Published by User:</strong></label>
          {{ currentBook.user.userName }} 
        </div>
        <div>
          <label><strong>Created in the library at:</strong></label>
          {{ currentBook.date }} 
        </div>
        <div>
          <label><strong>Editorial:</strong></label>
          {{ currentBook.editorial.name }}
        </div>
        <div>
          <label><strong>Status:</strong></label>
          {{ currentBook.availability ? "Available" : "Not Available" }}
        </div>
        <div>
          <label><strong>URL Access:</strong></label>
          {{ currentBook.url}}
        </div>
        <v-button
          class="badge badge-success"
          @click="setActiveBook()"
          >Access book
        </v-button>
        <v-button
          class="badge badge-warning"
          @click="setActiveBook()"
          >Edit
        </v-button>
        <span v-if="currentBook.user.id === userCurrent.id">
        <v-button
          class="badge badge-danger"
          @click="setActiveBook()"
          >Delete
        </v-button>
        </span>
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
import BookDataService from "../../services/bookData.service";

export default {
  name: "book-list",
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
      userCurrent: {},
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
    retrieveCurrentUser(){
      let user = JSON.parse(localStorage.getItem('user'));
      this.userCurrent = user;
    },
    retrieveBooks() {
      BookDataService.getCategoryBook(3)
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
    this.retrieveCurrentUser();
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
