<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
  <head>
    <title>Simple Map</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">

	    
    <spring:url value="/resources/js/map.js" var="mapjs" />
	<script src="${mapjs}"></script>
	
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDAmlVnV67VJg8y2x3Wu-LxedwvbIbiXZg&callback=initMap"
    async defer></script>    
    
    <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map-canvas{
        height: 50%;
      }
    </style>
  </head>
  <body>
    <div id="map-canvas"></div>
    <div> <button onclick="clickTest()">Click me</button></div>
    
    <!--  Hidden form that allows us to send POST to server that redirect using js -->
    <form style="display:none">
    	<input type="text" name="lat">
    	<input type="text" name="lon">
    </form>
    
  </body>
</html>