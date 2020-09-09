if('geolocation' in navigator){
						navigator.geolocation.getCurrentPosition(position=>{
							let latitude = position.coords.latitude;
							let longitude = position.coords.longitude;
							
							//Westmeath
//							const LAT = 53.5345;
//							const LONG = -7.4653;
							
							//Roscommon
							const LAT = 53.6340;
							const LONG = -8.1819;
							
							//Galway
// 							const LAT = 53.2707;
// 							const LONG = -9.0568;
							
							//Kildare
//							const LAT = 53.15611;
//							const LONG = -6.91444;
							
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
											$("#second").append(`<p>Current Location: ${data.results[0].formatted_address}</p>`);
										}
										if(`${part.long_name}` == "County Roscommon"){
											$("#second").append(`<p>Current Location: ${data.results[0].formatted_address}</p>`);
										}
										if(`${part.long_name}` == "County Galway"){
											$("#second").append(`<p>Current Location: ${data.results[0].formatted_address}</p>`);
										}
										if(`${part.long_name}` == "County Kildare"){
											$("#second").append(`<p>Current Location: ${data.results[0].formatted_address}</p><br><p>Health Check Unavailable Due to Covid Restrictions</p>`);
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
						console.log("Not Supported");
					}