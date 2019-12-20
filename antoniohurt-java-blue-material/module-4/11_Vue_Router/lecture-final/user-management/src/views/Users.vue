<template>
  <div class="users">
      <h1>Users</h1>
      <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="user in users" :key="user.id">
                <td>{{ user.id }}</td>
                <td><router-link :to="{ name:'user', params: { id: user.id } }">
                    {{ user.name }}
                    </router-link>
                </td>
            </tr>
        </tbody>
      </table>
  </div>
</template>

<script>
import UserService from '@/service/UserService'

export default {
    name: 'users',
    data() {
        return {
            users: []
        }
    },
    methods: {
        getUsers() {
            UserService.list().then(users => this.users = users);
        }
    },
    created() {
        this.getUsers();
    }

}
</script>

<style>
    td, th {
        padding: 6px;
        margin: 0px;
    }
    .tr:nth-child(even) {
        background-color: rgb(216, 216, 216);
    }
    a, a:hover, a:visited {
        color: blue;
        text-decoration: none;
        text-transform: uppercase;
    }
</style>