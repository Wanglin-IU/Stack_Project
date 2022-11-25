import Vue from 'vue'
import App from './App.vue'
import router from './router'
import VueParticlesBg from 'particles-bg-vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(ElementUI)
Vue.use(VueParticlesBg)

Vue.config.productionTip = false

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')
