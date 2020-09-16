var checkInURL = "http://localhost:8080/SCC/rest/checkin";
var checkOutURL = "http://localhost:8080/SCC/rest/checkout";

var findAllCheckIn = function(){
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: checkInURL,
		dataType: "json",
		success: renderListCheckIn
	});
};

var renderListCheckIn = function(data){
	var list=data;
	console.log("response");
	$.each(list, function(index, checkIn){
		$('#checkInBody').append('<tr><td>'+checkIn.checkInTime+'</td><td>'+checkIn.checkInDate+'</td></tr>');
	});
	$('#checkInTable').DataTable();
}

var findAllCheckOut = function(){
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: checkOutURL,
		dataType: "json",
		success: renderListnew
	});
};

var renderListCheckOut = function(data){
	var list=data;
	console.log("response");
	$.each(list, function(index, checkOut){
		$('#checkOutBody').append('<tr><td>'+checkOut.checkOutTime+'</td><td>'+checkOut.checkOutDate+'</td></tr>');
	});
	$('#checkOutTable').DataTable();
}

$(document).ready(function(){
	findAllCheckIn();
	findAllCheckOut();
})