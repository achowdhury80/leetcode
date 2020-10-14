package comp.prep2019.less1000;

public class Prob868 {
	public int binaryGap(int N) {
        int last = -1;
        int idx = 0;
        int result = 0;
        while(N > 0) {
        	if ((N & 1) == 1) {
        		if (last == -1) last = idx;
        		else {
        			result = Math.max(result, idx - last);
        			last = idx;
        		}
        	}
        	idx++;
        	N >>= 1;
        }
        return result;
    }
}
