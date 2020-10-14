package comp.prep2019.less1000;

import java.util.Arrays;

public class Prob881 {
	public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int result = 0;
        while(i <= j) {
        	if (i == j) {
        		result++;
        		i++;
        		j--;
        	}
        	else if (people[j] + people[i] <= limit) {
        		result++;
        		i++;
        		j--;
        	} else {
        		result++;
        		j--;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob881 prob = new Prob881();
		System.out.println(prob.numRescueBoats(new int[] {3, 2, 2, 1}, 3));
	}
}
