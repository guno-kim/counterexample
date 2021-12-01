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
    changeName:(data)=>{
        const url='/user/name'
        return axios.post(url,data)
    },
    get:()=>{
        const url='/user'
        return axios.get(url)
    },
    changeLanguage:(data)=>{
        const url='/user/language'
        console.log(data);
        
        return axios.post(url,data)
    },
    
}

export default userAPI