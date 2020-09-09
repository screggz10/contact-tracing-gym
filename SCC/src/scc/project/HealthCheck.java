package scc.project;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HealthCheck {

	private String fever;
	
	private String cough;
	
	private String breathless;
	
	private String soreThroat;
	
	private String chestPain;
	
	private String confirmedCase;
	
	private String travel;
	
	private String time;
	
	private String date;

	public String getFever() {
		return fever;
	}

	public void setFever(String fever) {
		this.fever = fever;
	}

	public String getCough() {
		return cough;
	}

	public void setCough(String cough) {
		this.cough = cough;
	}

	public String getBreathless() {
		return breathless;
	}

	public void setBreathless(String breathless) {
		this.breathless = breathless;
	}

	public String getSoreThroat() {
		return soreThroat;
	}

	public void setSoreThroat(String soreThroat) {
		this.soreThroat = soreThroat;
	}

	public String getChestPain() {
		return chestPain;
	}

	public void setChestPain(String chestPain) {
		this.chestPain = chestPain;
	}

	public String getConfirmedCase() {
		return confirmedCase;
	}

	public void setConfirmedCase(String confirmedCase) {
		this.confirmedCase = confirmedCase;
	}

	public String getTravel() {
		return travel;
	}

	public void setTravel(String travel) {
		this.travel = travel;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}