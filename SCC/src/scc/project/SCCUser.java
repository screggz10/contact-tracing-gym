package scc.project;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SCCUser {
	
	private int userID;
	
	private String userName;
	
	private String gender;
	
	private String emailAddress;
	
	private String password;
	
	private String phoneNumber;
	
	private String address;
	
	private String city;
	
	private SCCLogin credentials;
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public SCCLogin getCredentials() {
		return credentials;
	}

	public void setCredentials(SCCLogin credentials) {
		this.credentials = credentials;
	}

}
