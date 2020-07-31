package com.psl.bean;

import java.util.List;

public class HeadOffice {

	private String headOfficeId;
	private String city;
	private List<String> listOfPinCodes;
	

	@Override
	public String toString() {
		return "HeadOffice [headOfficeId=" + headOfficeId + ", city=" + city
				+ ", listOfPinCodes=" + listOfPinCodes + "]";
	}

	public HeadOffice(String headOfficeId, String city,
			List<String> listOfPinCodes) {
		super();
		this.headOfficeId = headOfficeId;
		this.city = city;
		this.listOfPinCodes = listOfPinCodes;
	}

	public String getHeadOfficeId() {
		return headOfficeId;
	}

	public void setHeadOfficeId(String headOfficeId) {
		this.headOfficeId = headOfficeId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<String> getListOfPinCodes() {
		return listOfPinCodes;
	}

	public void setListOfPinCodes(List<String> listOfPinCodes) {
		this.listOfPinCodes = listOfPinCodes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((headOfficeId == null) ? 0 : headOfficeId.hashCode());
		result = prime * result
				+ ((listOfPinCodes == null) ? 0 : listOfPinCodes.hashCode());
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
		if (!(obj instanceof HeadOffice)) {
			return false;
		}
		HeadOffice other = (HeadOffice) obj;
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (headOfficeId == null) {
			if (other.headOfficeId != null) {
				return false;
			}
		} else if (!headOfficeId.equals(other.headOfficeId)) {
			return false;
		}
		if (listOfPinCodes == null) {
			if (other.listOfPinCodes != null) {
				return false;
			}
		} else if (!listOfPinCodes.equals(other.listOfPinCodes)) {
			return false;
		}
		return true;
	}
	
	

}
