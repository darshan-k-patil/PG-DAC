package com.app.core;

public enum Color { //common super class of enum is java.lang.enum
	WHITE(10000), SILVER(20000), BLACK(15000), BLUE(35000), RED(50000);//all are single turns
	//0            1              2                3           4
	//static initializer block gets call once
	//state : Color cost
	private double colorCost;

	private Color(double colorCost) { //all methods are private inside enum
		//super(name,ordinal);
		this.colorCost = colorCost;
	}
	
	//getter
	public double getColorCost() {
		return colorCost;
	}
	@Override
	public String toString()
	{
		return name()+"@"+colorCost;
	}
	
}
