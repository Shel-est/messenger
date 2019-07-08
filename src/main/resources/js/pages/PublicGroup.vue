<template>
    <v-container>
        Coming soon
    </v-container>
</template>

<script>
import { mapState } from 'vuex'
    import publicGroupApi from 'api/publicGroup'

    export default {
        data() {
            return {
                publicGroup: {}
            }
        },
        computed: mapState(['publicGroups']),
        name: 'group',
        methods: {
            publicGroupFind() {
                return publicGroupApi.get(98)
            }
        },
        created() {
            publicGroup: publicGroupFind()
        },
    }

</script>

<style scoped>
</style>