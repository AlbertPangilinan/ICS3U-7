package com.bayviewglen.daythree;

public class AP11 {

	public int nextTankToFill (int threshold) {
		int minIndex = 0;
		for (int i = 0; i < tanks.size(); i++) {
			if (tanks.get(i).getFuelLevel < tanks.get(minIndex).getFuelLevel) {
				minIndex = i;
			}
		}
		if (tanks.get(minIndex).getFuelLevel <= threshold) {
			return minIndex;
		} else {
			return filler.getCurrentIndex;
		}
	}
	
	public void moveToLocation (int locIndex) {
		if (filler.getCurrentIndex > locIndex) && isFacingRight) {
			changeDirection(); 
		}
		if (filler.getCurrentIndex < locIndex) && !isFacingRight) {
			changeDirection(); 
		}
		moveForward(Math.abs(filler.getCurrentIndex - locIndex));
	}
	
}
