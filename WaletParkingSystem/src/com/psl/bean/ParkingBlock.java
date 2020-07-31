package com.psl.bean;

public class ParkingBlock{

	private int blockNumber;
	private int vehicleNumber;
	private int parkTime;
	private int outTime;
	private double charge;
	
	
	@Override
	public String toString() {
		return "ParkingBlock [blockNumber=" + blockNumber + ", vehicleNumber="
				+ vehicleNumber + ", parkTime=" + parkTime + ", outTime="
				+ outTime + ", charge=" + charge + "]";
	}
	
	public ParkingBlock(int blockNumber, int vehicleNumber, int parkTime,
			int outTime, double charge) {
		super();
		this.blockNumber = blockNumber;
		this.vehicleNumber = vehicleNumber;
		this.parkTime = parkTime;
		this.outTime = outTime;
		this.charge = charge;
	}
	public int getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNumber(int blockNumber) {
		this.blockNumber = blockNumber;
	}
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public int getParkTime() {
		return parkTime;
	}
	public void setParkTime(int parkTime) {
		this.parkTime = parkTime;
	}
	public int getOutTime() {
		return outTime;
	}
	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + blockNumber;
		long temp;
		temp = Double.doubleToLongBits(charge);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + outTime;
		result = prime * result + parkTime;
		result = prime * result + vehicleNumber;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingBlock other = (ParkingBlock) obj;
		if (blockNumber != other.blockNumber)
			return false;
		if (Double.doubleToLongBits(charge) != Double
				.doubleToLongBits(other.charge))
			return false;
		if (outTime != other.outTime)
			return false;
		if (parkTime != other.parkTime)
			return false;
		if (vehicleNumber != other.vehicleNumber)
			return false;
		return true;
	}	
}
