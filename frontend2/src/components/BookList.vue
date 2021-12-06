<template>
  <div class="flex flex-wrap">
    <div class="w-full">
      <ul class="flex mb-0 list-none flex-wrap pt-3 pb-4 flex-row">
        <li class="-mb-px mr-2 last:mr-0 flex-auto text-center">
          <a
            class="text-xs font-bold uppercase px-5 py-3 shadow-lg rounded block leading-normal"
            v-on:click="toggleTabs(1)"
            v-bind:class="{
              'text-pink-600 bg-white': openTab !== 1,
              'text-white bg-pink-600': openTab === 1,
            }"
          >
            <i class="fas fa-space-shuttle text-base mr-1"></i> Books
          </a>
        </li>
        <li class="-mb-px mr-2 last:mr-0 flex-auto text-center">
          <a
            class="text-xs font-bold uppercase px-5 py-3 shadow-lg rounded block leading-normal"
            v-on:click="toggleTabs(2)"
            v-bind:class="{
              'text-pink-600 bg-white': openTab !== 2,
              'text-white bg-pink-600': openTab === 2,
            }"
          >
            <i class="fas fa-cog text-base mr-1"></i> Scientific Articles
          </a>
        </li>
        <li class="-mb-px mr-2 last:mr-0 flex-auto text-center">
          <a
            class="text-xs font-bold uppercase px-5 py-3 shadow-lg rounded block leading-normal"
            v-on:click="toggleTabs(3)"
            v-bind:class="{
              'text-pink-600 bg-white': openTab !== 3,
              'text-white bg-pink-600': openTab === 3,
            }"
          >
            <i class="fas fa-briefcase text-base mr-1"></i> Presentations
          </a>
        </li>
      </ul>
      <div
        class="relative flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-lg rounded"
      >
        <div class="px-4 py-5 flex-auto">
          <div class="tab-content tab-space">
            <div v-bind:class="{ hidden: openTab !== 1, block: openTab === 1 }">
                <book-list></book-list>
            </div>
            <div v-bind:class="{ hidden: openTab !== 2, block: openTab === 2 }">
              <scientific-list></scientific-list>
            </div>
            <div v-bind:class="{ hidden: openTab !== 3, block: openTab === 3 }">
                <presentation-list></presentation-list>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ScientificList from './bookList/ScientificList.vue';
import PresentationList from './bookList/PresentationList.vue';
import BookList from './bookList/BookList.vue';

export default {
  components: { ScientificList, PresentationList, BookList },
  name: "list-books",
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
    toggleTabs: function (tabNumber) {
      this.openTab = tabNumber;
    },
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>
