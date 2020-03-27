package com.bean;

public class Milk extends Item {
	private float fatRate;
    private MilkType milkpacket;
    
    public Milk(){
    	
    }
	
    public float getFatRate() {
		return fatRate;
	}

	public void setFatRate(float fatRate) {
		this.fatRate = fatRate;
	}
	

	public MilkType getMilkpacket() {
		return milkpacket;
	}

	public void setMilkpacket(MilkType milkpacket) {
		this.milkpacket = milkpacket;
	}	
}


