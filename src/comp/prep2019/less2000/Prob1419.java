package comp.prep2019.less2000;
public class Prob1419 {
	public int minNumberOfFrogs(String croakOfFrogs) {
		int[] count = new int[5];
		int num = 0;
		for (int i = 0; i < croakOfFrogs.length(); i++) {
			char c = croakOfFrogs.charAt(i);
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
        for (int i = 0; i < count.length; i++) if (count[i] > 0) return -1;
        return num;
    }
}
