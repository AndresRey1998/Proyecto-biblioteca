import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import { FontAwesomeIcon } from './plugins/font-awesome'
import { loadFonts } from './plugins/webfontloader'
import vuetify from './plugins/vuetify'
import 'vuetify/styles'
import VueGoodTablePlugin from 'vue-good-table-next';
import 'vue-good-table-next/dist/vue-good-table-next.css'
import mitt from 'mitt';
import Datepicker from 'vue3-date-time-picker';
import 'vue3-date-time-picker/dist/main.css'
import './index.css'

loadFonts()
const emitter = mitt();
const app = createApp(App)

app.provide('emitter', emitter);  
app.component('Datepicker', Datepicker);

app.use(router)
  .use(store)
  .use(vuetify)
  .use(VueGoodTablePlugin)
  .component("font-awesome-icon", FontAwesomeIcon)
  .mount("#app");

