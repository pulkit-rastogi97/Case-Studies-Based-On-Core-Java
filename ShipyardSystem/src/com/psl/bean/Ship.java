package com.psl.bean;

import java.io.Serializable;
import java.util.Date;

public class Ship implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4539567133395318476L;
	private int shipNumber;
	private String destinationName;
	private Date startDate;
	private Date endDate;
	private double totalCost;
	private int numberOfDays;
	
	
	@Override
	public String toString() {
		return "Ship [shipNumber=" + shipNumber + ", destinationName="
				+ destinationName + ", startDate=" + startDate + ", endDate="
				+ endDate + ", totalCost=" + totalCost + ", numberOfDays="
				+ numberOfDays + "]";
	}
	public int getShipNumber() {
		return shipNumber;
	}
	public void setShipNumber(int shipNumber) {
		this.shipNumber = shipNumber;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public int getNumberOfDays() {
		return numberOfDays;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((destinationName == null) ? 0 : destinationName.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + numberOfDays;
		result = prime * result + shipNumber;
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Ship)) {
			return false;
		}
		Ship other = (Ship) obj;
		if (destinationName == null) {
			if (other.destinationName != null) {
				return false;
			}
		} else if (!destinationName.equals(other.destinationName)) {
			return false;
		}
		if (endDate == null) {
			if (other.endDate != null) {
				return false;
			}
		} else if (!endDate.equals(other.endDate)) {
			return false;
		}
		if (numberOfDays != other.numberOfDays) {
			return false;
		}
		if (shipNumber != other.shipNumber) {
			return false;
		}
		if (startDate == null) {
			if (other.startDate != null) {
				return false;
			}
		} else if (!startDate.equals(other.startDate)) {
			return false;
		}
		if (Double.doubleToLongBits(totalCost) != Double
				.doubleToLongBits(other.totalCost)) {
			return false;
		}
		return true;
	}
	
	
	
	
	
}
