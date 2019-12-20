<template>
    <div class="user">
        <h1>User</h1>
        {{ user }}
    </div>
</template>

<script>
import UserService from '@/service/UserService'

export default {
    name: 'user',
    data() {
        return {
            user: null
        }
    },
    methods: {
        getUser(id) {
            UserService.get(id).then( user => this.user = user );
        }
    },
    created() {
        const id = this.$route.params.id;
        this.getUser(id);
    }
}
</script>