package comp.prep2019.less2000;

public class Prob1461 {
	public boolean hasAllCodes(String s, int k) {
		int len;
		if ((len = s.length()) <= k) return false;
        int count = (1 << k);
        boolean[] arr = new boolean[count];
        int val = Integer.parseInt(s.substring(0, k), 2);
        arr[val] = true;
        count--;
        for (int i = k; i < len; i++) {
        	val &= (((1 << k) - 1) >> 1);
        	val = (val << 1) | (s.charAt(i) - '0');
        	if (!arr[val]) {
        		arr[val] = true;
        		count--;
        	}
        }
        if (count == 0) return true;
        return false;
    }
	
	public static void main(String[] args) {
		Prob1461 prob = new Prob1461();
		System.out.println(prob.hasAllCodes("00110110", 2));
	}
}
