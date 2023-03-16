<template>
  <div class="background-block">
    <h1 align="center">{{msg}}</h1>
    <form>
      <input type="text" >
    </form>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return{
      msg:''
    }
  },
  mounted() {
    fetch("~/api/messages/hello")
        .then((response) => response.text())
        .then((data) => {
          this.msg = data;
        })
  }
}
</script>

<style>
  .background-block{
    width: 75%;
    background-color: white;
    margin-left: auto;
    margin-right: auto;
    border-radius: 10px;
  }

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

  html{
    min-height: 100%;
    background:linear-gradient(0deg, rgba(0, 0, 0, 1.0), rgba(0, 0, 0, 0.0)), url(https://midwestcommunity.org/wp-content/uploads/2018/02/Groceries-ThinkstockPhotos-836782690.jpg);
    background-size: cover;
  }
</style>