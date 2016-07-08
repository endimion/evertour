$(document.body).on(
		'click',
		'.dropdown-menu li',
		function(event) {
			var $target = $(event.currentTarget);
			$target.closest('.btn-group').find('[data-bind="label"]').text(
					$target.text()).end().children('.dropdown-toggle')
					.dropdown('toggle');

			var $redirectUrl = $target.children().attr('href');

			filterTours($redirectUrl);
			return false;
		});



function filterTours(the_url) {
	deleteMarkers();
	var markers = httpGetAsync(the_url, putMarkersOnMap);
};




// Sets the map on all markers in the array.
function setMapOnAll(map) {
	for (var i = 0; i < markers.length; i++) {
		markers[i].setMap(map);
	}
}//end of setMapOnAll


//Removes the markers from the map, but keeps them in the array.
function clearMarkers() {
  setMapOnAll(null);
}

//Shows any markers currently in the array.
function showMarkers() {
  setMapOnAll(map);
}

// Deletes all markers in the array by removing references to them.
function deleteMarkers() {
  clearMarkers();
  markers = [];
}
