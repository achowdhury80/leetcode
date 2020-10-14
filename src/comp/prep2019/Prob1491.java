package comp.prep2019;

public class Prob1491 {
	public double average(int[] salary) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int sum = 0;
        for (int sal : salary) {
        	sum += sal;
        	max = Math.max(max, sal);
        	min = Math.min(min, sal);
        }
        sum -= (max + min);
        return sum / (salary.length - 2.0);
    }
}
