import axios from './axios'

const userAPI={
    logout:()=>{
        const url='/user/logout'
        return axios.get(url)
    },
    auth:()=>{
        const url='/user/auth'
        return axios.get(url)
    },
    update:(data)=>{
        const url='/user'
        return axios.post(url,data)
    },
    get:()=>{
        const url='/user'
        return axios.get(url)
    }

    
}

export default userAPI