package comp.prep2019;

public class Prob1432 {
	public int maxDiff(int num) {
		String s = "" + num;
		int max = num, min = num;
		char first = s.charAt(0);
		if (first != '9') {
			max = Integer.valueOf(s.replaceAll("" + first, "9"));
		} else {
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) != '9') {
					max = Integer.valueOf(s.replaceAll("" + s.charAt(i), "9"));
					break;
				}
			}
		}
		if (first != '1') {
			min = Integer.valueOf(s.replaceAll("" + first, "1"));
		} else {
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) > '1') {
					min = Integer.valueOf(s.replaceAll("" + s.charAt(i), "0"));
					break;
				}
			}
		}
        return max - min;
    }
	
	public static void main(String[] args) {
		Prob1432 prob = new Prob1432();
		System.out.println(prob.maxDiff(555));
	}
}
