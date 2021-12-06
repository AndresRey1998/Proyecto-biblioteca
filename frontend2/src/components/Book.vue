<template>
  <div class="parent">
    <div class="div1">
      <div class="submit-form mt-2 mx-auto">
        <h2>Add a new book</h2>
        <div v-if="!submitted">
          <v-form ref="form" lazy-validation>
            <div class="flex flex-wrap">
              <div class="w-full">
                <v-text-field
                  v-model="book.id"
                  required
                  label="ISSN"
                  type="number"
                />
              </div>
            </div>
            <div class="flex flex-wrap -mx-2 space-y-4 md:space-y-0">
              <div class="w-full px-2 md:w-1/2">
                <v-text-field
                  v-model="book.title"
                  :rules="[(v) => !!v || 'Username is required']"
                  label="Title"
                  required
                ></v-text-field>
              </div>
              <div class="w-full px-2 md:w-1/2">
                <v-text-field
                  v-model="book.editorial"
                  :rules="[(v) => !!v || 'Email is required']"
                  label="Editorial"
                  required
                >
                </v-text-field>
              </div>
            </div>
            <div class="flex flex-wrap -mx-2 space-y-4 md:space-y-0">
              <div class="w-full px-2 md:w-1/2">
                <label class="block mb-1" for="formGridCode_month"
                  >Date of publication</label
                >
                <Datepicker
                  v-model="book.date"
                  autoApply
                  position="center"
                  :maxDate="new Date()"
                  :enableTimePicker="false"
                ></Datepicker>
              </div>
              <div class="w-full px-2 md:w-1/2">
                <v-text-field
                  v-model="book.author"
                  :rules="[(v) => !!v || 'Email is required']"
                  label="Author/s"
                  required
                >
                </v-text-field>
              </div>
              <div class="w-full">
                <v-text-field
                  v-model="book.url"
                  :rules="[(v) => !!v || 'Username is required']"
                  label="URL"
                  required
                ></v-text-field>
              </div>

              <label class="block mb-1" for="formGridCode_month"
                >Category</label
              >
              <div class="relative inline-block w-full text-gray-700">
                <select
                  class="w-full h-10 pl-3 pr-6 text-base placeholder-gray-600 border rounded-lg appearance-none focus:shadow-outline"
                  placeholder="Regular input"
                  v-model="book.category"
                >
                  <option value=1>Book</option>
                  <option value=3>Scientific Article</option>
                  <option value=2>Presentation</option>
                </select>
                <div
                  class="absolute inset-y-0 right-0 flex items-center px-2 pointer-events-none"
                >
                  <svg class="w-4 h-4 fill-current" viewBox="0 0 20 20">
                    <path
                      d="M5.293 7.293a1 1 0 011.414 0L10 10.586l3.293-3.293a1 1 0 111.414 1.414l-4 4a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414z"
                      clip-rule="evenodd"
                      fill-rule="evenodd"
                    ></path>
                  </svg>
                </div>
              </div>
            </div>
            <v-btn color="primary" class="mt-3" @click="saveUser"
              >Submit new item</v-btn
            >
          </v-form>
        </div>

        <div v-else>
          <v-card class="mx-auto">
            <v-card-title> Submitted successfully! </v-card-title>

            <v-card-subtitle>
              Click the button to add new user.
            </v-card-subtitle>

            <v-card-actions>
              <v-btn color="success" @click="newUser">Add</v-btn>
            </v-card-actions>
          </v-card>
        </div>
      </div>
    </div>

    <div class="div2 align-center">
      <v-img
        class="mx-auto pa-15 pb-18 text-center"
        lazy-src="../assets/img/books_add.jpg"
        contain
        src="../assets/img/books_add.jpg"
      ></v-img>
    </div>
  </div>
</template>

<script>
import BookDataService from "../services/bookData.service";
import Multiselect from "@vueform/multiselect";

export default {
  name: "add-user",
  components: {
    Multiselect,
  },
  data() {
    return {
      book: {
        id: null,
        title: "",
        editorial: "",
        date: Date,
        author: "",
        url: "",
        category: null,
      },
    };
  },
  methods: {
    saveUser() {
      var data = {
        id: this.book.id,
        title: this.book.title,
        editorial: this.book.editorial,
        date: this.book.date,
        author: this.book.author,
        url: this.book.url,
        category: this.book.category,
      };

      BookDataService.saveBook(data);
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

.parent {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-template-rows: 1fr;
  grid-column-gap: 27px;
  grid-row-gap: 0px;
}

.multiselect-green {
  --ms-tag-bg: #d1fae5;
  --ms-tag-color: #059669;
}
.div1 {
  grid-area: 1 / 1 / 2 / 2;
}
.div2 {
  grid-area: 1 / 2 / 3 / 4;
}
</style>
