import axios from "axios";
import cookie from "react-cookies"


const SERVER_CONTEXT = "/AlumniApp";    
const SERVER = "http://localhost:8081";

export const endpoints = {
    "danhmuctintucs": `${SERVER_CONTEXT}/api/danhmuctintucs/`,
    "tintucs": `${SERVER_CONTEXT}/api/tintucs/`,
    "login": `${SERVER_CONTEXT}/api/login/`,
    "current-user": `${SERVER_CONTEXT}/api/current-user/`, 
    "register": `${SERVER_CONTEXT}/api/nguoidung/`, 
    "chitiets": (tintucId) => `${SERVER_CONTEXT}/api/tintucs/${tintucId}/`,
    "binhluans": (tintucId) => `${SERVER_CONTEXT}/api/tintucs/${tintucId}/binhluans/`,
    "them-binhluan": `${SERVER_CONTEXT}/api/binhluans/`,
}

export const authApi = () => {
    return axios.create({
        baseURL: SERVER,
        headers: {
            "Authorization": cookie.load("token")
        }
    })
}

export default axios.create({
    baseURL: SERVER
})