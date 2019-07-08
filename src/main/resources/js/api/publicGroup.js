import Vue from 'vue'

const publicGroups = Vue.resource('/publicGroup{/id}')

export default {
    get: id => publicGroups.get({id}),
    add: publicGroup => publicGroups.save({}, publicGroup),
}