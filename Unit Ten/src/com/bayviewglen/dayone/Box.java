package com.bayviewglen.dayone;

public class Box extends Rectangle implements Shape3D {

	private double height;

	public Box(double length, double width, double height) {
		super(length, width);
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getArea() {
		return (2 * getLength()  * getWidth()) + (2 * getLength() * getHeight()) + (2 * getWidth() * getHeight());
	}
	
	public double getVolume(double height) {
		return super.getArea(length, width) * height;
	}
}
