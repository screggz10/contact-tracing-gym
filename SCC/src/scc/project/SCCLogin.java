package scc.project;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SCCLogin {
	
	private String username;
	
	private String password;
	
	private int accessID;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccessID() {
		return accessID;
	}

	public void setAccessID(int accessID) {
		this.accessID = accessID;
	}

}
