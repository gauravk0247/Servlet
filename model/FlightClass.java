package model;

import java.time.LocalDate;

public class FlightClass {
	private int flightId;
	private String flightName;
	private String flightSrc;
	private String flightDesc;
	private double flightPrice;
	private LocalDate flightDate;
	
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getFlightSrc() {
		return flightSrc;
	}
	public void setFlightSrc(String flightSrc) {
		this.flightSrc = flightSrc;
	}
	public String getFlightDesc() {
		return flightDesc;
	}
	public void setFlightDesc(String flightDesc) {
		this.flightDesc = flightDesc;
	}
	public double getFlightPrice() {
		return flightPrice;
	}
	public void setFlightPrice(double flightPrice) {
		this.flightPrice = flightPrice;
	}
	public LocalDate getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}
}