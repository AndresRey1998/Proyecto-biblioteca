<template>
<div>
   <div class="section overlay-dark80 light-color pt-30 mb-30  pb-sm-30" style="background:#323232; height: 100%;">
            <v-container class="text-left fill-heigth">
            <div class="row">
            <div class="about-text col-md-7 mb-30">
						<h3 class=" h3-white padding-30 shadow" style="background-color:#8BC6CA;">&nbsp&nbspSobre Nosotros</h3>
						<div class="padding-20 shadow" style="margin:-10px 0 0 15px;background: rgba(255,255,255,0.08);">
						<p class="p-white">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc tristique rhoncus lectus et vulputate.
                            Etiam dui tellus, fringilla id urna vel, porttitor molestie nulla. Sed at velit eu nunc dictum facilisis.
                            Mauris in orci ultrices, molestie dolor sit amet, tempus neque. Pellentesque habitant morbi tristique
                            senectus et netus et malesuada fames ac turpis egestas. Mauris gravida id quam a accumsan. Sed quis
                            justo in massa ultrices pulvinar id et mauris. Donec at dapibus turpis.</p>
						<p class="p-white">Fusce feugiat sapien ut mollis tincidunt. Praesent molestie ipsum quis purus molestie cursus.
                             Suspendisse mattis vestibulum dui a hendrerit. Suspendisse potenti.</p>
						<btn class="btn-white btn-white:hover">DAME MÁS INFORMACIÓN</btn>
						</div>
					</div>
					<div class="col-xs-0 col-xs-offset-0 col-sm-1 col-md-offset-0 col-md-5">
						<img class="aligncenter" v-bind:src="require('../assets/img/Sobre-Nosotros-2.png')" />
					</div>
          </div>
            </v-container>
        </div>

      <div class="section ">
      <div class="container">
      <div class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-slide-to="0" class="active"></li>
          <li data-slide-to="1"></li>
          <li data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img class="d-block  " v-bind:src="require('../assets/img/carrusel-3.jpeg')" alt="First slide">
          </div>
          <div class="carousel-item">
            <img class=" d-block w-100 " v-bind:src="require('../assets/img/carrusel-2.jpg')" alt="Second slide">
          </div>
          <div class="carousel-item">
            <img class="d-block w-100 " v-bind:src="require('../assets/img/carrusel-3.jpeg')" alt="Third slide">
          </div>
        </div>
        <a class="carousel-control-prev" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
      </div>
      </div>  
      
       


</div> 

</template>

<script>


export default {
  name: "Home",
  data() {
    return {
      content: "",
    };
  },
  mounted() {
    /*UserService.getPublicContent().then(
      (response) => {
        this.content = response.data;
      },
      (error) => {
        this.content =
          (error.response &&
            error.response.data &&
            error.response.data.message) ||
          error.message ||
          error.toString();
      }
    );*/
  },
};
</script>


<style>
   @import '../assets/css/style.css';

</style>