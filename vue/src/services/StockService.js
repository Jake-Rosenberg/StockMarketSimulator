import axios from "axios";





export default {
  getAllStocks() {
    return axios.get("stocks");
  },
  getStockByStockId(stockId) {
    return axios.get(`stock?id=${stockId}`, stockId);
  },
  getStockByTicker(ticker) {
    return axios.get(`stock?ticker=${ticker}`);
  },
  createStock(ticker, name, currentPrice) {
    return axios.post("stocks/create", ticker, name, currentPrice);
  },
  updateCurrentPrice(ticker) {
    return axios.put(`stocks/${ticker}/price`);
  },
};

//may need some changes
