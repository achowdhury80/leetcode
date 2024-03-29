package com.prep2020.medium;

import java.util.Random;

public class Problem478 {
	private double x_center, y_center, radius;
	private Random random;
	public Problem478(double radius, double x_center, double y_center) {
		this.x_center = x_center;
        this.y_center = y_center;
        this.radius = radius;
        this.random = new Random();
    }
    
    public double[] randPoint() {
        double x = Math.random(), y = Math.random();
        while( x * x + y * y > 1) {
        	x = Math.random();
        	y = Math.random();
        }
        
        return new double[] {x_center + (random.nextInt(2) == 0 ? -1 : 1) * x * radius,
        		y_center + (random.nextInt(2) == 0 ? -1 : 1) * y * radius};
    }
}
