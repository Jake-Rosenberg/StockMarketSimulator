<template>
  <div id="stock-box">
    <h1>Stocks Available</h1>
    <stock-list></stock-list>
  </div>
</template>

<script>
import StockList from "@/components/StockList";

export default {
  name: "stock",
  components: {
    StockList,
  },
};
</script>

<style>
#stock-box {
  padding: 5%;
  background-color: lightyellow;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 300px;
  height: 400px;
  border: 4px navy solid;
  border-radius: 10px;
  padding: 50px;
  margin: auto;
  margin-top: 60px;
}
</style>
