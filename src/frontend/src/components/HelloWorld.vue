<template>
  <div class="row">
    <div class="col-md-3"></div>
    <div style="margin-top: 50px; padding-bottom: 10px;" class="col-md-6 rounded bg-white">
      <h1 align="center" class="fw-bold">{{msg}}</h1>
      <form @submit.prevent="submit">
        <input type="text" v-model="productName">
        <button class="btn btn-success fw-bold w-100" @click="GetAllResults">Search product</button>
      </form>
    </div>
    <div class="col-md-3"></div>
  </div>

  <div class="row" style="margin-top: 10px" v-for="Product in products" :key="Product.name">
    <div class="col-md-2"></div>
    <div class="col-md-8 bg-white rounded">
      <div class="row">
        <div class="col-md-3"><img  :src="Product.imgLink" style="width: 100%; height: 100%"></div>
        <div class="col-md-6"><h1 align="center" style="margin-top: 13%">{{Product.name}}</h1></div>
        <div class="col-md-3">
          <h2 align="center" style="margin-top: 13%">€ {{Product.price}}</h2>
        </div>
      </div>
    </div>
    <div class="col-md-2"></div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'HelloWorld',
  data() {
    return{
      productName: '',
      products: [],
      msg:''
    }
  },
  mounted() {
    fetch("~/api/messages/hello")
        .then((response) => response.text())
        .then((data) => {
          this.msg = data;
        })
  },
  methods: {
    GetAllResults(){
      axios.post('~/api/scraper/GetProducts', this.productName)
          .then(response =>{
            this.products = response.data;
          })
          .catch(error => {
            console.error(error);
          })
    }
  }
}
</script>

<style>

  input[type=text] {
    width: 90%;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    background-color: white;
    background-image: url('https://www.w3schools.com/css/searchicon.png');
    background-position: 10px 10px;
    background-repeat: no-repeat;
    padding: 12px 20px 12px 40px;
    margin-left: 5%;
    margin-right: 5%;
    margin-bottom: 1%;
  }


</style>