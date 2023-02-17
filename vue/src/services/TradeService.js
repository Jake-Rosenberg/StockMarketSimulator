import axios from "axios";

export default {
  

  getTradeByTradeId(tradeId) {
    return axios.get(`/trades/${tradeId}`, tradeId);
  },

  getTradesByAccountId(accountId) {
    return axios.get(`/trades/${accountId}/trades`, accountId);
  },

  getTradesByStockIdAndAccountId(accountId, stockId) {
    return axios.get(`/accounts/${accountId}/stocks/${stockId}`, accountId, stockId);
  },

  createTrade(trade) {
    return axios.post('/trades/create', trade);
  }


};
