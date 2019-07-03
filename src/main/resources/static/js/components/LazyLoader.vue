<template>
    <v-container>
    </v-container>
</template>

<script>
	import { mapActions } from 'vuex'

    export default {
        name: 'LazyLoader',
        methods: mapActions(['loadPageAction']),
        mounted() {
        	window.onscroll = () => {
        		const el = document.documentElement
        		const isBottomOfScreen = el.scrollTop + window.innerHeight === el.offsetHeight

        		if (isBottomOfScreen) {
        			this.loadPageAction()
        		}
        	}
        },
        beforeDestroyed() {
        	window.onscroll = null
        d},
    }
</script>

<style scoped>
</style>