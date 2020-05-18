package comp.prep2019;

public class Prob1103 {
	public int[] distributeCandies(int candies, int num_people) {
		int[] result = new int[num_people];
		int i = 1, idx = 0;
        while(candies > 0) {
        	int min = Math.min(candies, i);
        	result[idx] += min;
        	idx = (idx + 1) % num_people;
        	candies -= min;
        	i++;
        }
        return result;
    }
}
