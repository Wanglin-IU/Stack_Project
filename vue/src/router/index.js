import Vue from 'vue'
import VueRouter from 'vue-router'
import A_All from "@/views/A_All";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'All',
        component: A_All
    },
    {
        path: '/Top10',
        name: 'Top10',
        component: () => import('../views/B_Top')
    },
    {
        path: '/Compare',
        name: 'Compare',
        component: () => import('../views/C_Compare')
    },
    {
        path: '/Random',
        name: 'Random',
        component: () => import('../views/D_Random')
    },
    {
        path: '/SMonth',
        name: 'SMonth',
        component: () => import('../views/E_SMonth')
    },
    {
        path: '/Lower',
        name: 'Lower',
        component: () => import('../views/F_Lower')
    },
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
