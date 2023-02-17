<template>
  <div>
    <h1>Create Trade</h1>
    <div id="trade-form">
      <trade-form></trade-form>
    </div>
  </div>
</template>

<script>
import TradeForm from "@/components/TradeForm";

export default {

    name: "add-trade",
  components: {
    TradeForm,
  },
};
</script>

<style>
#trade-form {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
</style>
