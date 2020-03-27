package com.bean;

public class Wheat extends Item {
	private WheatType wheatType;

	public Wheat() {
	}

	public WheatType getWheatType() {
		return wheatType;
	}

	public void setWheatType(WheatType wheatType) {
		this.wheatType = wheatType;
	}
}
