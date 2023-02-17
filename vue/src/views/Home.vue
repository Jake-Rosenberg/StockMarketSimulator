<template>
  <div class="home">
    <h1>Meet JARMS!</h1>
    <div>
      <img
        src="..\assets\stockgrouphoto.jpg.jpeg"
        alt="placeholder Photo"
        class="group-photo"
      />
    </div>

    <!-- <p>You must be authenticated to see this</p> -->
    <h1>Featured $tocks</h1>

    <div id="featured-stocks">
      <div>
        <img
          src="..\assets\The_Walt_Disney_company_logo.png"
          id="disney"
          alt=""
        />
      </div>
      <div></div>
      <figure>
        <img src="..\assets\Peloton_LogoCopy.png" id="peloton" alt="peloton" />
        <!-- <figcaption>TESTING 123</figcaption> -->
      </figure>
      <div></div>
      <img src="..\assets\stridelogo.jpg" id="stride" alt="stride" />
    </div>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>

<style>
h2 {
  text-align: center;
  margin: 40px 0 40px;
  text-align: center;
  font-size: 30px;
  color: #ecf0f1;
  text-shadow: 2px 2px 4px #000000;
}
.create-btn {
  background-color: #fbeee0;
  border: 2px solid #422800;
  border-radius: 30px;
  box-shadow: #422800 4px 4px 0 0;
  color: #422800;
  cursor: pointer;
  display: inline-block;
  font-weight: 600;
  font-size: 18px;
  padding: 0 18px;
  line-height: 50px;
  text-align: center;
  text-decoration: none;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  display: flex;
  flex-direction: column;
  margin: 15px;
}

/* .logo {
  display: flex;
  flex-direction: column;
  position: relative;
  height: 200px;
  width: 200px;
  align-items: center;
  justify-content: center;
  margin: 20% 25% 20% 35%;
  padding: 0px 0px 70px 0px;
} */

.create-btn:hover {
  background-color: #fff;
}

.create-btn:active {
  box-shadow: #422800 2px 2px 0 0;
  transform: translate(2px, 2px);
}
.group-photo {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 35%;
  border: 20px solid black;
}

#featured-stocks {
  display: flex;
  flex-direction: row;
  flex: 1fr 1fr 1fr;
  justify-content: center;
  align-items: center;
  width: auto;
  height: auto;
  /* border: 5px black solid; */
}

#disney {
  width: 250px;
  height: 175px;
}

#peloton {
  width: 275px;
  height: 275px;
}
#stride {
  width: 275px;
  height: 150px;
}

@media (min-width: 768px) {
  .create-btn {
    min-width: 120px;
    padding: 0 25px;
  }
}
</style>
