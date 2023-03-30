import { createApp } from 'vue'
import App from './App.vue'

import 'bootstrap/dist/css/bootstrap.css'
import bootstrap from 'bootstrap/dist/js/bootstrap'
import { createAuth0 } from '@auth0/auth0-vue';

createApp(App).use(bootstrap).use(
    createAuth0({
        domain: "dev-oempr7he.eu.auth0.com",
        clientId: "QpcDWLrMbkTGoif33wouk01DXaqbQfcA",
        authorizationParams: {
            redirect_uri: window.location.origin
        }
    })
).mount('#app')