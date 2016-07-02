// send an asynchronous js POST to the given url and process
// the response given the callback
function httpPOSTAsync(theUrl, callback) {
	var http = new XMLHttpRequest();
	var params = "p1=lorum&p2=kadf";
	http.open("POST", theUrl, true); // true for asynchronous
	// Send the proper header information along with the request
	http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

	// when the state changes use the callback to process the request
	http.onreadystatechange = function() {
		if (http.readyState == 4 && http.status == 200)
			callback(http.responseText);
	}
	http.send(params);
}// end of httpPostAsync

function testProcessPOSTsucess(responseText) {
	alert("Success!");
	// console.log(responseText);
}

function longclickTest() {
	// http://localhost:8080/GuidesV1/
	the_url = "add/tour/new";
	httpPOSTAsync(the_url, testProcessPOSTsucess);
}

// asynchronously retrieve the url and processing using
// the callback passed
function httpGetAsync(theUrl, callback) {
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
			callback(xmlHttp.responseText);
	}
	xmlHttp.open("GET", theUrl, true); // true for asynchronous
	xmlHttp.send(null);
}

var my_map;
function initMap() {
	my_map = new google.maps.Map(document.getElementById('map-canvas'), {
		center : new google.maps.LatLng(39.978846, 23.763825),
		zoom : 12,
		mapTypeId : 'roadmap',
		mapTypeControlOptions : {
			style : google.maps.MapTypeControlStyle.DROPDOWN_MENU
		}
	});

	// check if the browser supports geolocation
	// and center it
	if (navigator.geolocation) {
		// get the current position async, and call
		// as a callback the setmapinit pos function
		navigator.geolocation.getCurrentPosition(setMapInitPosition);
	} else {
		error('Geo Location is not supported');
	}

	// centers the map to the given position
	// should be used with nav.geoloc.getCurrentPosition
	function setMapInitPosition(position) {
		// alert(position.coords.latitude);
		// position.coords.longitude;
		var lat = position.coords.latitude;
		var lon = position.coords.longitude;
		var latlng = new google.maps.LatLng(lat, lon);
		my_map.setCenter(latlng);
	}// end of setMapInintPosition

	var clickPosition;
	/*
	 * add listners to the map, to detect a loongclick
	 */
	google.maps.event.addListener(my_map, 'mousedown', function(event) {
		start = new Date().getTime();
		clickPosition = event.latLng;
		// alert(clickPosition);

	});
	google.maps.event.addListener(my_map, 'mouseup', function(event) {
		end = new Date().getTime();
		if (end - start >= 500) {
			// window.location="http://www.google.com";
			console.log("long click detected");
			// longclickTest();
			// get the address from the latLng of the clicked spot on the map
			// asynch, and inside a callback redirect
			var lat = clickPosition.lat();
			var lng = clickPosition.lng();
			httpGetAsync("http://maps.googleapis.com/maps"
					+ "/api/geocode/json?latlng=" + lat + "," + lng
					+ "&sensor=true", function(text) {

				var response = JSON.parse(text);
				console.log(response);
				var address = response.results[0].formatted_address;
				
				//then create a fake form and use that to submit it
				// this allows us to redirect to the page we will post to
				var form = document.createElement("form");
				form.name="form";
				form.method = 'POST';
				form.action = 'add/tour/new/form';
				
				var latInput = document.createElement('input');
				latInput.type = "text";
				latInput.name = "lat";
				latInput.value = lat;
				form.appendChild(latInput);
				
				var lonInput = document.createElement('input');
				lonInput.type = "text";
				lonInput.name = "lng";
				lonInput.value = lng;
				form.appendChild(lonInput);
				
				var addrInput = document.createElement('input');
				addrInput.type = "text";
				addrInput.name = "address";
				addrInput.value = address;
				form.appendChild(addrInput);
				
				form.style.display="none";
				document.body.appendChild(form);
				form.submit();
				
				//the alternative would be to go to the url to add a form
				// synchronously using:
				/*window.location = "add/tour/new/?address=" + address + "&lat="
						+ lat + "&lng=" + lng;*/
				//but this would make the url ugly
			});

		}
	});

}// end of mapinit


//THIS IS A GLOBAL VARIABLE  THAT STORE ALL THE MARKERS ON THE MAP
var markers = [];


/**
 * @param text a JSON containing the serilization of a list or ToursTO
 * reads each object in the JSON and adds a marker in the map for each such object
 * by reading the latitude and longtitude
 */
function putMarkersOnMap(text) {
	var response = JSON.parse(text);
	// alert(response[1].name);
	//console.log(response);

	for (var i = 0; i < response.length; i++) {
		var latlng = new google.maps.LatLng(parseFloat(response[i].lat),
				parseFloat(response[i].lng));
		// alert(response[i].lat);
		var marker = new google.maps.Marker({
			position : latlng,
			map : my_map,
			title : response[i].name
		});
		markers[i] = marker
	}// end of for

	for (i = 0; i < markers.length; i++) {
		// for each marker add an onclick event that
		// redirects you to the page displaying the events details

		// due to javascript closures (look this up more)
		// The solution, is to wrap this in an anonymous function to get
		// Javascript to evaluate the value of "key" at the time that the click
		// listener is added.
		google.maps.event.addListener(markers[i], 'click', function(innerKey) {
			return function() {
				// infowindows[innerKey].open(map, markers[innerKey]);
				window.location.href = "display/tour/?name="
						+ response[innerKey].name;
			}
		}(i));
	}

}// end of processJSON

function getAllTours() {
	// http://localhost:8080/GuidesV1/
	the_url = "find/tours/all";
	var markers = httpGetAsync(the_url, putMarkersOnMap);

}

function CategorySelectionChanged(catId){
	window.location.href = "filterToursByCategory/?catId="+catId;
}
