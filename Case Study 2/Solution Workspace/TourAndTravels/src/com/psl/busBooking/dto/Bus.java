package com.psl.busBooking.dto;

import java.time.LocalDate;

public class Bus {

	private int busId;
	private String busType;
	private String from;
	private String to;
	private LocalDate date;
	private int noOfSeats;
	public Bus(int busId, String busType, String from, String to,
			LocalDate date, int noOfSeats) {
		this.busId = busId;
		this.busType = busType;
		this.from = from;
		this.to = to;
		this.date = date;
		this.noOfSeats = noOfSeats;
	}
	public Bus() {
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busType=" + busType + ", from="
				+ from + ", to=" + to + ", date=" + date + ", noOfSeats="
				+ noOfSeats + "]";
	}
	
	
}
