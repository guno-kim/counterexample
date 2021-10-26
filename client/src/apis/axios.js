import axios from 'axios';


const axiosClient = axios.create({
    //baseURL: 'http://api.algohelper.ga',
    baseURL: process.env.REACT_APP_ServerDomain,
    withCredentials:true, // cookie 받기 위해 설정
})

export default axiosClient;
