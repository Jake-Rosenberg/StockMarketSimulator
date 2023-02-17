<template>
  <div>

<div>
      <table id= "tblStocks">
        <thead>
          <tr>
            <th>Stock</th>
          </tr>
          <tr>
            <td>
              <input type="text" id="stockFilter" v-model="search.name"/>
            </td>
            <td><button v-on:click="doSearch">Search</button></td>
          </tr>
        </thead>
      </table>
    </div>

    <div class="test-style">
      <table>
        <tbody>
          <!-- <tr class="stock" v-for="stock in stocks" v-bind:key="stock.name" v-on:click="handleClick(stock)"> -->
            <tr>
            <!-- <td><input type="checkbox" v-bind:username="user.username" v-bind:value="user.username" v-model="selectedUsers"/></td> -->
            <td id="single-stock">{{stock.name}}</td>
            <td id="single-stock">{{stock.price}}</td>
          </tr>
        </tbody>
      </table>
    </div>


  </div>
</template>

<script>

import StockService from "../services/StockService";

export default {
name: "stock-list",

data() {
    return {
    stock: {},
    // stock: {
    //   ticker: '',
    //   price: '',
    //   name: ''
    // },
    search:{
      name: ''
    },

    filter: {
      name: ''
    },
};
},

computed: {
  filteredList(){
    return this.stocks.filter((stock) => {
      if(stock.name.toLowerCase().includes(this.search.name)){
        return stock;
      }
    })
  }
},
methods: {
  doSearch() {
    StockService.getStockByTicker(this.search.name).then(response=> {
      this.stock = response.data;

    })
  },
  handleClick(stock) {
    console.log(stock);
  }
},

created(){
  // StockService.getAllStocks().then(response => {
    // this.stocks = response.data;
    // .map(stock => {
    //   return StockService.getStockByTicker(stock.ticker);
    // })

  },

}


</script>

<style>

</style>