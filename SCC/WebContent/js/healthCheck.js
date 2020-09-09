var rootURL = "http://localhost:8080/SCC/rest/healthcheck";

var getLocation = function(){
	if(navigator.geolocation){
		navigator.geolocation.getCurrentPosition(position=>{
			let latitude = position.coords.latitude;
			let longitude = position.coords.longitude;
			
			const LAT = latitude;
			const LONG = longitude;
			
			const KEY = "AIzaSyBn6dOEaz9qx-AVGodVH3TViHUx4pulURs";
			let url = `https://maps.googleapis.com/maps/api/geocode/json?latlng=${LAT},${LONG}&key=${KEY}`;
			
			fetch(url)
			.then(response => response.json())
			.then(data => {
				console.log(data);
				let parts = data.results[0].address_components;
				parts.forEach( part => {
					if(part.types.includes("political")){
						if(`${part.long_name}` == "County Offaly"){
							$("#healthCheckOffaly").show();
						}
						if(`${part.long_name}` == "County Westmeath"){
							$("#healthCheckWestmeath").show();
						}
						if(`${part.long_name}` == "County Roscommon"){
							$("#healthCheckRoscommon").show();
						}
						if(`${part.long_name}` == "County Galway"){
							$("#healthCheckGalway").show();
						}
						if(`${part.long_name}` == "County Kildare"){
							$("#healthCheckKildare").show();
						}
					}
				})
			})
			.catch(err => console.warn(err.message));
			
			console.log(latitude, longitude);
		},error=>{
			console.log(error.code);
		},{
			enableHighAccuracy:true
		});
		
	}else{
		alert("Location can't be found")
	}
};



$(document).ready(function() {
	
	$("#healthCheckOffaly").hide();
	$("#healthCheckWestmeath").hide();
	$("#healthCheckRoscommon").hide();
	$("#healthCheckGalway").hide();
	$("#healthCheckKildare").hide();
	
	getLocation();
	
	if($("#btnSubmit").click(function(){
		addHealthCheck();
	}));
	
});

var addHealthCheck = function() {
	console.log('addHealthCheck');
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : rootURL,
		dataType : "json",
		data : formToJSON(),
		success : function(data, textStatus, jqXHR) {
			alert('HealthCheck Added');
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('HealthCheck error: ' + textStatus);
		}
	});
};

var formToJSON = function(){
	var fever = $("input[name='fever']:checked").val();
	var cough = $("input[name='cough']:checked").val();
	var breathless = $("input[name='breathless']:checked").val();
	var soreThroat = $("input[name='soreThroat']:checked").val();
	var chestPain = $("input[name='chestPain']:checked").val();
	var confirmedCase = $("input[name='confirmedCase']:checked").val();
	var travel = $("input[name='travel']:checked").val();
	
	var c = new Date();
	var clock = c.toLocaleTimeString();
	
	var d = new Date();
	var date = d.toLocaleDateString();
	
	return JSON.stringify({
		"fever": fever,
		"cough": cough,
		"breathless": breathless,
		"soreThroat": soreThroat,
		"chestPain": chestPain,
		"confirmedCase": confirmedCase,
		"travel": travel,
		"time" : clock,
		"date" : date
	});
};