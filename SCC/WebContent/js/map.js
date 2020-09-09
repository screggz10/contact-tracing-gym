//define the points of the area (lat and long)
// latitude up and down
// longitude across

// showing field and current location on map
function initMap() {
	const map = new google.maps.Map(document.getElementById("map"), {
		zoom : 5,
		center : {
			lat : 53.3950,
			lng : -7.7186
		},
		mapTypeId : "terrain"
	});

	const mapCoords = [ {
		lat : 53.4239,
		lng : -7.9407
	}, {
		lat : 53.5259,
		lng : -7.3381
	}, {
		lat : 53.0328,
		lng : -7.2988
	}, {
		lat : 53.0928,
		lng : -8.2185
	} ];

	const fieldArea = new google.maps.Polygon({
		paths : mapCoords,
		strokeColor : "#FF0000",
		strokeOpacity : 0.8,
		strokeWeight : 2,
		fillColor : "#FF0000",
		fillOpacity : 0.35
	});
	fieldArea.setMap(map);

	// marker for current position
	navigator.geolocation.getCurrentPosition(initialize, fail);

	// outside map, Galway
//	 isPointInside( [53.2707, -9.0568] , mapArea);
	function initialize(position) {
		var myLatLng = new google.maps.LatLng(53.2707, -9.0568);
		//var myLatLng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
		new google.maps.Marker({
			position : myLatLng,
			map : map
		});
	}
	function fail() {
		alert('navigator.geolocation failed, may not be supported');
	}

};

// checking is current location inside
function isPointInside(point, vs) {
	
	var x = point[0], y = point[1];

	var inside = false;
	
	for (var i = 0, j = vs.length - 1; i < vs.length; j = i++) {
		var xi = vs[i][0], yi = vs[i][1];
		var xj = vs[j][0], yj = vs[j][1];
		
		var intersect = ((yi > y) != (yj > y)) && (x < (xj - xi) * (y - yi) / (yj - yi) + xi);
		
		if (intersect){
			inside = !inside;
		}
		
	}
	
	return inside;
	
};

var mapArea = [
	[53.4239, -7.9407],
	[53.5259, -7.3381],
	[53.0328, -7.2988],
	[53.0928, -8.2185] ];

function whereIsLocation() {
	// get position
	navigator.geolocation.getCurrentPosition(initialize, fail);

	function initialize(position) {
		// outside map, Galway
		var result = isPointInside( [53.2707, -9.0568] , mapArea);
		//var result = isPointInside([position.coords.latitude,position.coords.longitude], mapArea);
		if(result == true){
			insideMap();
		}
		if(result == false){
			outsideMap();
		}
		console.log(result)
	}
	
	function fail() {
		alert('navigator.geolocation failed, may not be supported');
	}
}

$(document).ready(function() {
	$('#insideField').click(function() {
		whereIsLocation();
	});
})

var insideMap = function(){
	alert("You are located inside the area");
};

var outsideMap = function(){
	alert("You are located outside the area");
};
