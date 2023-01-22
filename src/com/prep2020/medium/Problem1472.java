package com.prep2020.medium;
import java.util.*;
public class Problem1472 {
	private List<String> urls;
	private int index = -1;
	public Problem1472(String homepage) {
        urls = new ArrayList<>();
        urls.add(homepage);
        index = 0;
    }
    
    public void visit(String url) {
        while(index + 1 < urls.size()) urls.remove(index + 1);
        urls.add(url);
        index++;
    }
    
    public String back(int steps) {
        if (index - steps >= 0) {
        	index -= steps;
        	return urls.get(index);
        }
        index = 0;
        return urls.get(index);
    }
    
    public String forward(int steps) {
        if (index + steps < urls.size()) {
        	index += steps;
        	return urls.get(index);
        }
        index = urls.size() - 1;
        return urls.get(index);
    }
    
    public static void main(String[] args) {
    	Problem1472 problem = new Problem1472("leetcode.com");
    	problem.visit("google.com");
    	problem.visit("facebook.com");
    	problem.visit("youtube.com");
    	System.out.println(problem.back(1));
    	System.out.println(problem.back(1));
    	System.out.println(problem.forward(1));
    	problem.visit("linkedin.com");
    	System.out.println(problem.forward(2));
    	System.out.println(problem.back(2));
    	System.out.println(problem.back(7));
    }
}
