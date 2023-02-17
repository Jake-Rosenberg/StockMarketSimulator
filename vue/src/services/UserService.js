import axios from "axios";

export default {

    getUserById(id) {
        return axios.get(`users/${id}`, id);
    },

    getAllUsers() {
        return axios.get('users');
    }

}