package comp.prep2019;
public class Prob467 {
	public int findSubstringInWraproundString(String p) {
	    if (p == null || p.equals("")) return 0;
	    int n;
	    if ((n = p.length()) < 2) return 1;
	    // max number of continuous substring ending with char (index + 'a')
	    int[] count = new int[26];
	    int maxSubstringCount = 0;
	    // at any index find the max substring till that index which is continous
	    for (int i = 0; i < p.length(); i++) {
	      if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) maxSubstringCount++;
	      else maxSubstringCount = 1;
	      count[p.charAt(i) - 'a'] = Math.max(count[p.charAt(i) - 'a'], maxSubstringCount);
	    }

	    int sum = 0;
	    //find sum
	    for (int i = 0; i < 26; i++) sum += count[i];
	    return sum;

	  }
	
	public static void main(String[] args) {
		Prob467 prob = new Prob467();
		System.out.println(prob.findSubstringInWraproundString("zab"));
		System.out.println(prob.findSubstringInWraproundString("abaab"));
		System.out.println(prob.findSubstringInWraproundString("cofzxdlhnf"));
	}
}
