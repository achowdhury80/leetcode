package comp.prep2019.less1000;

public class Prob277 {
	/**
	 * celeb do not know anybody. that also need to be checked.
	 * @param n
	 * @return
	 */
	public int findCelebrity(int n) {
        int probCeleb = 0;
        for (int i = 1; i < n; i++) {
        	if (!knows(i, probCeleb)) {
        		probCeleb = i;
        	}
        }
        
        for (int i = 0; i < n; i++) {
        	if (i != probCeleb) {
        		if (knows(probCeleb, i) || !knows(i, probCeleb)) return -1;
        	}
        }
        return probCeleb;
        
    }
	
	boolean knows(int a, int b) {
		return true;
	}
}
