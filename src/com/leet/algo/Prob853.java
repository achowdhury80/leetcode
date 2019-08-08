package com.leet.algo;

import java.util.Arrays;

public class Prob853 {
	public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n < 2) return n;
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) cars[i] = new Car(position[i], speed[i], target);
        Arrays.sort(cars, (x, y) -> x.position - y.position);
        int result = 0;
        for (int i = n - 1; i > 0; i--) {
        	if (cars[i].time < cars[i - 1].time) result++;
        	else cars[i - 1] = cars[i];
        }
        result++;
        return result;
    }
	
	class Car {
		int position;
		double time;
		Car(int position, int speed, int target){
			this.position = position;
			time = (target - position + 0.0) / speed;
		}
	}
	
	public static void main(String[] args) {
    	Prob853 prob = new Prob853();
    	System.out.println(prob.carFleet(12, new int[] {10, 8, 0, 5, 3}, new int[] {2,4,1,1,3}));
    	
    }
}
