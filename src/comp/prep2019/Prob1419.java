package comp.prep2019;

public class Prob1419 {
	public int minNumberOfFrogs(String croakOfFrogs) {
        int num = 0;
        int[] count = new int[5];
        for (char c : croakOfFrogs.toCharArray()) {
        	int idx = "croak".indexOf(c);
        	if (c == 'c') {
        		if (num > 0) num--;
        		count[idx]++;
        	} else {
        		if (count[idx - 1] == 0) return -1;
        		count[idx - 1]--;
        		count[idx]++;
        		if (c == 'k') {
        			num++;
        			count[idx]--;
        		}
        	}
        }
        for (int i = 0; i < 5; i++) if (count[i] > 0) return -1;
        return num;
    }
}
