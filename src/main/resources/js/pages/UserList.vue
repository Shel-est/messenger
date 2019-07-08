<template>
    <v-container>
        <v-layout align-space-around justify-start column>
            <user-link class="py-2"
                v-for="user in userList"
                :user="user"
                size="48"
            >
            </user-link>
        </v-layout>
    </v-container>
</template>

<script>
    import UserLink from 'components/UserLink.vue'
    import userApi from 'api/userList'

    export default {
        components: {UserLink},
        name: 'UserList',
        data() {
            return {
                userList: []
            }
        },
        methods: {
            async getUserList() {
                const data = await userApi.list()
                this.userList = await data.json()
            }
        },
        beforeMount() {
            this.getUserList()
        }
    }

</script>

<style scoped>
</style>