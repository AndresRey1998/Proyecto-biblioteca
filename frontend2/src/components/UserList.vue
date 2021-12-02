<template>
  <div>
    <vue-good-table
      :columns="columns"
      :rows="users"
      :row-style-class="rowStyleClassFn"
      :paginate="true">
   </vue-good-table>
 </div>
</template>

<script>
import UserDataService from "../services/userData.service";
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
        { label: "Actions", field: "actions", sortable: false}
      ],
    };
  },
  methods: {
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
      this.$router.push({ name: "user-details", params: { id: id } });
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
        state: user.enable
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