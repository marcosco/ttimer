<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	.wrapper {
	  position: relative;
	  margin: 40px auto;
	  background: white;
	}
	
	.wrapper, .wrapper * {
	  -moz-box-sizing: border-box;
	  -webkit-box-sizing: border-box;
	  box-sizing: border-box;
	}
	
	.wrapper {
	  width: 250px;
	  height: 250px;
	}
	
	.wrapper .pie {
	  width: 50%;
	  height: 100%;
	  transform-origin: 100% 50%;
	  position: absolute;
	  background: #08C;
	  border: 5px solid rgba(0,0,0,0.5);
	}
	
	.wrapper .spinner {
	  border-radius: 100% 0 0 100% / 50% 0 0 50%;
	  z-index: 200;
	  border-right: none;
	  -webkit-animation: rota 5s linear infinite;
	}
	
	.wrapper:hover .spinner,
	.wrapper:hover .filler,
	.wrapper:hover .mask {
	  -webkit-animation-play-state: running;
	}
	
	.wrapper .filler {
	  border-radius: 0 100% 100% 0 / 0 50% 50% 0;
	  left: 50%;
	  opacity: 0;
	  z-index: 100;
	  -webkit-animation: opa 5s steps(1, end) infinite reverse;
	  border-left: none;
	}
	
	.wrapper .mask {
	  width: 50%;
	  height: 100%;
	  position: absolute;
	  background: inherit;
	  opacity: 1;
	  z-index: 300;
	  -webkit-animation: opa 5s steps(1, end) infinite;
	}
	
	@-webkit-keyframes rota {
	  0% {
	    transform: rotate(0deg);
	  }
	  100% {
	    transform: rotate(360deg);
	  }
	}
	@-webkit-keyframes opa {
	  0% {
	    opacity: 1;
	  }
	  50%, 100% {
	    opacity: 0;
	  }
	}
</style>
<div class="wrapper">
  <div class="pie spinner"></div>
  <div class="pie filler"></div>
  <div class="mask"></div>
</div>