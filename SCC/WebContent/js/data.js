var rootURL = "http://localhost:8080/SCC/rest/checkin";
var rootURLnew = "http://localhost:8080/SCC/rest/checkout";

$(document).ready(function(){
	findAll();
	findAllnew();
})

var findAll = function(){
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURL,
		dataType: "json",
		success: renderList	
	});
};

var renderList = function(data){
	var list=data;
	console.log("response");
	$.each(list, function(index, checkIn){
		$('#checkInBody').append('<tr><td>'+checkIn.checkInTime+'</td><td>'+checkIn.checkInDate+'</td></tr>');
	});
	$('#checkInTable').DataTable();
}

var findAllnew = function(){
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURLnew,
		dataType: "json",
		success: renderListnew
	});
};

var renderListnew = function(data){
	var list=data;
	console.log("response");
	$.each(list, function(index, checkOut){
		$('#checkOutBody').append('<tr><td>'+checkOut.checkOutTime+'</td><td>'+checkOut.checkOutDate+'</td></tr>');
	});
	$('#checkOutTable').DataTable();
}