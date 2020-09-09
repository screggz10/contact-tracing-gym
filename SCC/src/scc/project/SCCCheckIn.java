package scc.project;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SCCCheckIn {
	
	private String checkInTime;
	
	private String checkInDate;

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	
}
