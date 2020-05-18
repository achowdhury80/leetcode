package comp.prep2019;

public class Prob306 {
	public boolean isAdditiveNumber(String num) {
		int n;
        if ((n = num.length()) < 3) return false;
        for (int i = 0; i < (n - 1) / 2; i++) {
        	if (i > 0 && num.charAt(0) == '0') return false;
        	long first = Long.parseLong(num.substring(0, i + 1));
        	for (int j = i + 1; Math.max(i + 1, j - i) <= n - j - 1  ; j++) {
        		if (j - i > 1 && num.charAt(i + 1) == '0') break;
        		long second = Long.parseLong(num.substring(i + 1, j + 1));
        		if (isAdditive(j + 1, first, second, num)) return true;
        	}
        }
        return false;
    }
	
	private boolean isAdditive(int start, long first, long second, String num) {
		long next = 0l + first + second;
		String nextStr = "" + next;
		if (num.indexOf(nextStr, start) != start) return false;
		if (start + nextStr.length() == num.length()) return true;
		return isAdditive(start + nextStr.length(), second, next, num); 
	}
	
	public static void main(String[] args) {
		Prob306 prob = new Prob306();
		System.out.println("121474836472147483648".length());
		System.out.println(prob.isAdditiveNumber("121474836472147483648"));
	}
}
