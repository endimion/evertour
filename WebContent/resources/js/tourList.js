window.addEventListener("load",function(e){
	
	var tourDivs = document.getElementsByClassName("tour-list")[0].getElementsByClassName("tour-list-wrapper");
	
	
	/**
	 * You can just use a closure to save the 
	 * index of that iteration. Otherwise there are shared by the same 
	 * function scope and will give you the value of the same iteration. 
	 */
	
	
	for(i=0; i<tourDivs.length; i++){
		(function(index,tourD){
			var tourId = tourD[index].querySelector("#tourId").value;
			console.log("tour id is "+ tourId);
			tourD[index].addEventListener("mouseover",function(){
				console.log("in hovered" + tourId);
				var marker = markers[tourId]
				marker.setAnimation(google.maps.Animation.BOUNCE);
				var latLng = marker.getPosition(); // returns LatLng object
				my_map.setCenter(latLng); 
			});
		})(i,tourDivs);
		
	
		
		tourDivs[i].addEventListener("mouseout",function(){
			console.log("out hovered");
		});
	}//end of looping through the divs
	
});