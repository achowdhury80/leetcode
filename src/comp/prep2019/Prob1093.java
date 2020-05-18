package comp.prep2019;

public class Prob1093 {
	public double[] sampleStats(int[] count) {
        double min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        double sum = 0;
        int elemCount = 0;
        int[] maxFreq = new int[2];
        for (int i = 0; i < count.length; i++) {
        	if (count[i] > 0) {
        		min = Math.min(min, i);
        		max = Math.max(max, i);
        		sum += i * count[i];
        		if (maxFreq[1] < count[i]) {
        			maxFreq[0] = i;
        			maxFreq[1] = count[i];
        		}
        		elemCount += count[i];
        	}
        }
        int freq = 0, median2 = elemCount / 2, median1 = (elemCount - 1) / 2; 
        double median = 0;
        for (int i = 0; i < count.length; i++) {
        	if (count[i] > 0) {
        		freq += count[i];
        		if (freq > median1) {
        			if (freq > median2) {
        				median = i;
        				break;
        			} else {
        				for (int j = i + 1; j < count.length; j++) {
        					if (count[j] > 0) {
        						median = (i + j) / 2.0;
        						break;
        					}
        				}
        				break;
        			}
        		}
        	}
        }
        return new double[] {min, max, (sum + 0.0) / elemCount, median, maxFreq[0]};
    }
	
	public static void main(String[] args) {
		Prob1093 prob = new Prob1093();
		double[] result = prob.sampleStats(new int[] {0, 1, 3, 4});
		for (int i = 0; i < result.length; i++) System.out.print(result[i] + ", ");
	}
}
