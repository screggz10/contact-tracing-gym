var rootURL = "http://localhost:8080/SCC/rest/checkin";
var rootURLnew = "http://localhost:8080/SCC/rest/checkout";

$(document).ready(function() {
	
	if($("#no").click(function(){
		login();
	}));
	if($("#yes").click(function(){
		$("#covid").hide();
		$("#second").append("<p>Get out of the Gym......CANT!!!!!!</p>")
	}));
	
	$("#signIn").hide();
});
		
var login = function() {
	$("#covid").hide();
	$("#signIn").show();
	$("#login").click(function() {
		
			if ($("#loginUserName").val() == 'admin' && $("#loginPassword").val() == 'pass') {
					$("#signIn").hide();
					document.title = "Thank You";
					
					//geolocation
					if('geolocation' in navigator){
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
								let newLocation = data.results[0].formatted_address;
								$("#second").append(`<p>Current Location: ${data.results[0].formatted_address}</p>`);
							})
							.catch(err => console.warn(err.message));
							
							console.log(latitude, longitude);
						},error=>{
							console.log(error.code);
						},{
							enableHighAccuracy:true
						});
					}else{
						console.log("Not Supported");
					}
					
					addCheckIn();
					$('#second').append("</p><input type='button' id='logout' value='Sign Out' />");
					} else {
						alert("Please try again")
					}
					$("#logout").click(function() {
						$("form")[0].reset();
						addCheckOut();
						$("#signIn").show();
						$("#second").hide();
					});
					
		});
};

var addCheckIn = function() {
	console.log('addCheckIn');
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : rootURL,
		dataType : "json",
		data : formToJSON(),
		success : function(data, textStatus, jqXHR) {
			alert('CheckIn Time Added');
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('CheckIn error: ' + textStatus);
		}
	});
};

var addCheckOut = function() {
	console.log('addCheckOut');
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : rootURLnew,
		dataType : "json",
		data : formToJSON2(),
		success : function(data, textStatus, jqXHR) {
			alert('CheckOut Time Added');
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('CheckOut error: ' + textStatus);
		}
	});
};

var formToJSON = function(){
	var c = new Date();
	var clock = c.toLocaleTimeString();
	
	var d = new Date();
	var date = d.toLocaleDateString();
	
	return JSON.stringify({
		"checkInTime" : clock,
		"checkInDate" : date
	});
};

var formToJSON2 = function(){
	var c = new Date();
	var clock = c.toLocaleTimeString();
	
	var d = new Date();
	var date = d.toLocaleDateString();
	
	return JSON.stringify({
		"checkOutTime" : clock,
		"checkOutDate" : date
	});
};




