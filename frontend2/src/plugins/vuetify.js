// Styles
import '@mdi/font/css/materialdesignicons.css'
import 'vuetify/styles'

// Vuetify
import { createVuetify } from 'vuetify'
import * as components from 'vuetify/lib/components/index'
import * as directives from 'vuetify/lib/directives/index'

export const vuetify = createVuetify(
  components,
  directives
) // Replaces new Vuetify(...)

export default createVuetify(
  // https://vuetifyjs.com/en/introduction/why-vuetify/#feature-guides
)
