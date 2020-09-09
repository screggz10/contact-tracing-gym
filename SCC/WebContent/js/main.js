var rootURL = "http://localhost:8080/SCC/rest/scc";

$(document).ready(function() {
	$('#signUp').click(function(){
		window.location.assign("http://localhost:8080/SCC/createUser.html");
	});
	
	$('#checkIn').click(function(){
		window.location.assign("http://localhost:8080/SCC/checkIn.html");
	});
	
	$('#dataTable').click(function(){
		window.location.assign("http://localhost:8080/SCC/dataTable.html");
	})
	
	$('#users').click(function(){
		window.location.assign("http://localhost:8080/SCC/viewUsers.html");
	})
	
	$('#health').click(function(){
		window.location.assign("http://localhost:8080/SCC/healthCheck.html");
	})
	
	$('#map').click(function(){
		window.location.assign("http://localhost:8080/SCC/map.html");
	})
});
