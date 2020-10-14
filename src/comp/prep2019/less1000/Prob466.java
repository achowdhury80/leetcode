package comp.prep2019.less1000;

public class Prob466 {
	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
		if (n1 == 0) return 0;
		// index at start of each s1 block
	    int indexr[] = new int[s2.length() + 1]; 
	    // count of repititions till the present s1 block
	    int countr[] = new int[s2.length() + 1]; 
	    int count = 0, index = 0;
	    for (int i = 0; i < n1; i++) {
	    	for (int j = 0; j < s1.length(); j++) {
	    		if (s1.charAt(j) == s2.charAt(index)) {
	    			index++;
	    		}
	    		if (index == s2.length()) {
	    			index = 0;
	    			count++;
	    		}
	    	}
	    	indexr[i] = index;
	    	countr[i] = count;
	    	for (int k = 0; k < i; k++) {
	    		if (indexr[k] == index) {
	    			int prev_count = countr[k];
	    			int pattern_count = (countr[i] - countr[k]) * ((n1 - 1 - k) / (i - k));
	    			int remain_count = countr[k + ((n1 - 1 - k) % (i - k))] - countr[k];
	    			return (prev_count + pattern_count + remain_count) / n2;
	    		}
	    	}
	    	
	    }
	    return countr[n1 - 1] / n2;
    }
}
