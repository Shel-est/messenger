import Vue from 'vue'

const userList = Vue.resource('/users')

export default {
    list: listUsers => Vue.http.get(`/users/list`)
}