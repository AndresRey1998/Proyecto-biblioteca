<template>
    <div>
    <h1>List of editorials</h1>
    <vue-good-table
      :columns="columns"
      :rows="editorials"
      :row-style-class="rowStyleClassFn"
      :paginate="true"
      :responsive="true"
      :sort-options="{
        enabled: true,
        initialSortBy: { field: 'id', type: 'asc' },
      }"
      :pagination-options="{
        enabled: true,
        mode: 'records',
        perPage: 5,
      }"
      :search-options="{
        enabled: true,
        trigger: 'enter',
        skipDiacritics: true,
        placeholder: 'Search here an editorial!',
      }"
    >
      <template #table-row="props">
        <span v-if="props.column.field == 'actions'">
          <button
            size="sm"
            @click="modalEdit(props)"
            variant="primary"
            class="mr-2"
            title="Edit"
          >
            <i> Edit </i>
          </button>
          <button
            size="sm"
            variant="danger"
            class="mr-2"
            title="Hapus"
            @click="disableEnableUser(props)"
          >
            Delete
          </button>
        </span>
      </template>
    </vue-good-table>
  </div>
</template>

<script>
import EditorialDataService from "../services/editorialData.service";
import { openModal } from "jenesius-vue-modal";
//import ModalEditUser from "./modals/ModalEditEditorial.vue";
import { inject } from "vue";

export default {
   name: "listeditorials",
  data() {
    return {
      editorials: [],
      columns: [
        { label: "ID", field: "id" },
        {
          label: "Name",
          field: "name",
          filterOptions: {
            enabled: true,
            placeholder: "Filter by user",
            filterDropdownItems: [],
            filterFn: this.columnFilterFn,
          },
        },
        { label: "Email", field: "email" },
        { label: "Address", field: "address" },
        { label: "Telephone", field: "telephone", sortable: false },
        { label: "Actions", field: "actions", sortable: false },
      ],
    };
  },
  methods: {
    columnFilterFn: function (data, filterString) {
      return data.includes(filterString);
    },
  
    modalEdit(props) {
      const listRoles = props.row.roles.split(",");
      openModal(ModalEditUser, {
        id: props.row.id,
        username: props.row.username,
        email: props.row.email,
        roles: listRoles,
        state: props.row.state,
      });

      document.getElementsByTagName("body")[0].style = "overflow:hidden;";
    },

    rowStyleClassFn(row) {},
    retrieveEditorials() {
      EditorialDataService.getAll()
        .then((response) => {
            console.log(response)
          this.editorials = response.data.map(this.getDisplayEditorial);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    refreshList() {
      this.retrieveEditorials();
    },

    getDisplayEditorial(editorial) {
      return {
        id: editorial.id,
        name: editorial.name,
        email: editorial.email,
        address: editorial.address,
        telephone: editorial.telephone,
      };
    },
  },
  mounted() {
    this.retrieveEditorials();
    const emitter = inject("emitter");
    emitter.on("refreshEvent", () => {
      this.retrieveEditorials();
      this.refreshList();
    });
  },
};
</script>

<style>


</style>