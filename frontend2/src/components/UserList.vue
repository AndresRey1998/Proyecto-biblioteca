<template>
  <div>
    <h1>List of users</h1>
    <vue-good-table
      :columns="columns"
      :rows="users"
      :row-style-class="rowStyleClassFn"
      :paginate="true"
      :responsive="true"
      :pagination-options="{
      enabled: true,
      mode: 'records',
      perPage: 5,
      }"
    :search-options="{
    enabled: true,
    trigger: 'enter',
    skipDiacritics: true,
    placeholder: 'Search here an user!'}"
    >
          <template #table-row="props">
                <span v-if="props.column.field == 'actions'">
                  <button size="sm" @click="modalEdit(props)" variant="primary" class="mr-2" title="Edit">
                    <i>
                        Edit
                      </i>
                  </button>
                  <button size="sm" variant="danger" class="mr-2" title="Hapus" @click="disableEnableUser(props)">
                    <i>
                         Disable
                      </i>
                  </button>
                </span>
                    <span v-if="props.column.field == 'state'">
                      <span v-if="props.row.state == true">
                        <span style="font-weight: bold; color: green;">Activated</span> 
                      </span>
                      <span v-else>
                        <span style="font-weight: bold; color: red;">Not activated</span> 
                    </span>
                  </span>
                  
                <span v-else>
                  {{props.formattedRow[props.column.field]}}
                </span>
              </template>
   </vue-good-table>
 </div>
</template>

<script>
import UserDataService from "../services/userData.service";
import { openModal } from "jenesius-vue-modal";
import ModalEditUser from './modals/ModalEditUser.vue'
import { inject } from 'vue'

export default {
  name: "listusers",
  data() {
    return {
      users: [],
      columns: [
        { label: "ID", field: "id"},
        { label: "Username", field: "username",    
        filterOptions: {
  	    enabled: true, 
        placeholder: 'Filter by user', 
        filterDropdownItems: [],
        filterFn: this.columnFilterFn,
      },
    },
        { label: "Email", field: "email" },
        { label: "State", field: "state" },
        { label: "Permissions", field: "roles", sortable: false },
        { label: "Actions", field: "actions", sortable: false}
      ],
    };
  },
  methods: {
    columnFilterFn: function(data, filterString) {
    return data.includes(filterString);
  },
    disableEnableUser(props){
      UserDataService.disableEnableUser(props.row.id)
    },
    modalEdit(props){
      openModal(ModalEditUser, {
        id: props.row.id,
        username: props.row.username,
        email: props.row.email,
        roles: props.row.roles,
        state: props.row.state
      })
      
      document.getElementsByTagName('body')[0].style = 'overflow:hidden;';
  },

  rowStyleClassFn(row) {

  },
    retrieveUsers() {
      UserDataService.getAll()
        .then((response) => {
          this.users = response.data.map(this.getDisplayUser);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    refreshList() {
      this.retrieveUsers();
    },

    editUser(id) {
      console.log(id)
    },

    deleteUser(id) {
      UserDataService.delete(id)
        .then(() => {
          this.refreshList();
        })
        .catch((e) => {
          console.log(e);
        });
    },
  
    getDisplayUser(user) {
      return {
        id: user.id,
        username: user.userName,
        email: user.email,
        state: user.enable,
        roles: user.roles
      };
    },
  },
  mounted() {
    this.retrieveUsers();
    const emitter = inject("emitter");
    emitter.on('refreshEvent', () => {
      console.log("TRIGGER")
      this.retrieveUsers();
      this.refreshList()
      
    })
  },
};
</script>

<style>
.list {
  max-width: 750px;
}
</style>