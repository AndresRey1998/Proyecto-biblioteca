<template>
  <div>
    <vue-good-table
      :columns="columns"
      :rows="users"
      :row-style-class="rowStyleClassFn"
      :paginate="true"
      :responsive="true">
          <template #table-row="props">
                <span v-if="props.column.field == 'actions'">
                  <button size="sm" @click="modalEdit(props)" variant="primary" class="mr-2" title="Edit">
                    <i>
                        <font-awesome-icon icon="edit" /> Edit
                      </i>
                  </button>
                  <button size="sm" variant="danger" class="mr-2" title="Hapus">
                    <i>
                        <font-awesome-icon icon="trash" /> Disable
                      </i>
                  </button>
                </span>
                    <span v-if="props.column.field == 'state'">
                      <span v-if="props.row.state == 'Activated'">
                        <span style="font-weight: bold; color: green;">{{props.row.state}}</span> 
                      </span>
                      <span v-else>
                        <span style="font-weight: bold; color: red;">{{props.row.state}}</span> 
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

export default {
  name: "users-list",
  data() {
    return {
      users: [],
      columns: [
        { label: "ID", field: "id"},
        { label: "Username", field: "username" },
        { label: "Email", field: "email" },
        { label: "State", field: "state" },
        { label: "Permissions", field: "roles" },
        { label: "Actions", field: "actions", sortable: false}
      ],
    };
  },
  methods: {
    modalEdit(props){
      openModal(ModalEditUser, {
        username: props.row.username,
        email: props.row.email,
        roles: this.users.roles
      })
      
      document.getElementsByTagName('body')[0].style = 'overflow:hidden;';
  },

  rowStyleClassFn(row) {
    console.log(row)
    return row.state === true ? row.state="Activated" : 'Not Activated';
  },
    retrieveUsers() {
      UserDataService.getAll()
        .then((response) => {
          this.users = response.data.map(this.getDisplayUser);
          console.log(response.data);
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
        username: user.userName.length > 30 ? user.userName.substr(0, 30) + "..." : user.userName,
        email: user.email.length > 30 ? user.email.substr(0, 30) + "..." : user.email,
        state: user.enable,
        roles: user.roles
      };
    },
  },
  mounted() {
    this.retrieveUsers();
  },
};
</script>

<style>
.list {
  max-width: 750px;
}
</style>