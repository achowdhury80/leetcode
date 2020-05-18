package comp.prep2019;

public class Prob972 {
	public boolean isRationalEqual(String S, String T) {
        long[] sArr = retrieveFraction(S);
        long[] tArr = retrieveFraction(T);
        return sArr[0] * tArr[1] == sArr[1] * tArr[0];
    }
	
	private long[] retrieveFraction(String s) {
		int nonRecCount = 0, recCount = 0;
		boolean fractionStarted = false, recurStarted = false;;
		long numer = 0, nonRecurring = 0, denom = 1;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '.') {
				fractionStarted = true;
				continue;
			} 
			if (!recurStarted && c != '.' && c != '(') {
				nonRecurring = nonRecurring * 10 + (c - '0');
			}
			if (!fractionStarted) {
				numer = numer * 10 + (c - '0');
			} else {
				if (c == '(') {
					recurStarted = true;
				} else if (c != ')') {
					numer = numer * 10 + (c - '0');
					if (!recurStarted) {
						nonRecCount++;
					} else {
						recCount++; 
					}
				}
			}
		}
		if (recurStarted) numer -= nonRecurring;
		denom = 1;
		if (recurStarted) {
			denom = 0;
			for (int i = 0; i < recCount; i++) {
				denom = denom * 10 + 9;
			}
		} 
		for (int j = 0; j < nonRecCount; j++) {
			denom = denom * 10;
		}
		return new long[] {numer, denom};
	}
	
	public static void main(String[] args) {
		Prob972 prob = new Prob972();
		//System.out.println(prob.isRationalEqual("0.(52)", "0.5(25)"));
		System.out.println(prob.isRationalEqual("0.9(9)", "1."));
	}
}
