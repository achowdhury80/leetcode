package comp.prep2019.less2000;

public class Prob1111 {
	public int[] maxDepthAfterSplit(String seq) {
        int[] arr = new int[seq.length()];
        int max = 0;
        int cur = 0;
        for (int i = 0; i < seq.length(); i++) {
        	if (seq.charAt(i) == '(') {
        		cur++;
        		arr[i] = cur;
        		max = Math.max(max, cur);
        	} else {
        		arr[i] = cur;
        		cur--;
        	}
        }
        max = max / 2;
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] > max) arr[i] = 1;
        	else arr[i] = 0;
        }
        return arr;
    }
}
