package comp.prep2019.less1000;

public class Prob495 {
	public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        int lastEnd = 0, start = 0;;
        for (int time : timeSeries) {
        	if (lastEnd < time) {
        		result += lastEnd - start;
        		start = time;
        	}
        	lastEnd = time + duration;
        }
        result += lastEnd - start;
        return result;
    }
}
