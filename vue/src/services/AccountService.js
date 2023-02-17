import axios from "axios";

export default {

    getAccountByAccountId(id) {
        return axios.get(`/accounts/${id}`, id);
    },

    getAccountByUserId(userId) {
        return axios.get(`/accounts/${userId}/accounts`, userId);

    },

    getCurrentUserAccounts() {
        return axios.get('/users/me/accounts');
    },

    getAccountsByGameId(gameId) {
        return axios.get(`/games/${gameId}/accounts`);

     },
     
    createAccountsByGameId(gameId, userIds) {
        return axios.post(`/accounts/${gameId}/create`, userIds);
    },

    createAccount(userId, gameId) {
        return axios.post('/accounts/create', userId, gameId);

     },
    
     updateBalance(id) {
         return axios.put(`/accounts/${id}/balance`) // might need entire object to update balance (account.id)

    },

    getAccountSummary(id) {
        return axios.get(`/accounts/${id}/costBasis`)
    }

    // newBalance() {

    //  },

}
