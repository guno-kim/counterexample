import {AUTH_USER,LOGIN_USER,LOGOUT_USER,UPDATE_USER} from './type'
import userAPI from '../apis/user'
export async function auth(){
    const req=await userAPI.auth().then(res=>res.data)
    return{
        type:AUTH_USER,
        auth:req.auth,
        data:req.data
    }
}
export async function logout(){
    const req=await userAPI.logout().then(res=>res.data)
    return{
        type:LOGOUT_USER,
        success:req.success
    }
}
export async function update(data){
    const req=await userAPI.update(data).then(res=>res.data)
    return{
        type:UPDATE_USER,
        data:req.data
    }
}
