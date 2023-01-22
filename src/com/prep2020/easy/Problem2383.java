package com.prep2020.easy;

public class Problem2383 {
	public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int result = 0;
        for (int i = 0; i < energy.length; i++) {
        	if (initialEnergy <= energy[i]) {
        		int toAdd = (1 + energy[i] - initialEnergy);
        		initialEnergy += toAdd;
        		result += toAdd;
        	}
        	if (initialExperience <= experience[i]) {
        		int toAdd = (1 + experience[i] - initialExperience);
        		initialExperience += toAdd;
        		result += toAdd;
        	}
        	initialExperience += experience[i];
        	initialEnergy -= energy[i];
        }
        return result;
    }
}
