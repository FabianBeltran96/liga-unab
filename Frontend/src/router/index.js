import Vue from 'vue'
import VueRouter from 'vue-router'
import PartidosView from '../views/PartidosView.vue'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/home',
    name: 'home',
    component: HomeView
  },
  {
    path: '/partidos',
    name: 'partidos',
    component: PartidosView
  },

]

const router = new VueRouter({
  routes
})

export default router
