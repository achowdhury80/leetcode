package com.leet.algo;
import java.util.*;
public class Prob478 {
	
	private double radius, x, y;
	private Random random;
	
	public Prob478(double radius, double x_center, double y_center) {
        this.x = x_center;
        this.y = y_center;
        this.radius = radius;
        random = new Random();
    }
    
	public double[] randPoint() {
        double[] ans=new double[2];
        
        double x=Math.random();
        double y=Math.random();
        
        while(x*x+y*y>1) {
        	x=Math.random();
            y=Math.random();
        }
        int flagx=random.nextInt(2)==0?1:-1;
        int flagy=random.nextInt(2)==0?1:-1;
        
        ans[0]=x+flagx*radius*x;
        ans[1]=y+flagy*radius*y;
        
    	return ans;
    }
}
