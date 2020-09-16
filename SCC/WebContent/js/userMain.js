var userURL = "http://localhost:8080/SCC/rest/user";

// create user
var addUser = function() {
	console.log('addUser');
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : userURL,
		dataType : "json",
		data : formToJSON(),
		success : function(data, textStatus, jqXHR) {
			alert('User created successfully.');
			window.location.assign("http://localhost:8080/SCC/checkIn.html");
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('addUser error: ' + textStatus);
		}
	});
}

// Helper function to serialize all the form fields into a JSON string
var formToJSON = function() {
	return JSON.stringify({
		"userName" : $('#inputFullName').val(),
		"gender" : $('#inputGender').val(),
		"emailAddress" : $('#inputEmail').val(),
		"password" : $('#inputPassword').val(),
		"phoneNumber" : $('#inputTelephone').val(),
		"address" : $('#inputAddress').val(),
		"city" : $('#inputCity').val(),
	})

}

var findAll = function(){
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: userURL,
		dataType: "json",
		success: renderList	
	});
};

var renderList = function(data){
	var list=data;
	console.log("response");
	$.each(list, function(index, users){
		$('#usersBody').append('<tr><td>'+users.userID+'</td><td>'+users.userName+'</td><td>'+users.emailAddress+'</td></tr>');
	});
	$('#usersTable').DataTable();
}

$(document).ready(function() {

	// create sign up function
	$('#btnSignUp').click(function() {
		addUser();
		return false;
	});
	// create back function
	$('#btnBack').click(function() {
		window.location.assign("http://localhost:8080/SCC/");
		return false;
	});
	
	findAll();

});