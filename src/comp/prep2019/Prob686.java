package comp.prep2019;

public class Prob686 {
	/**
	 * https://leetcode.com/problems/repeated-string-match/solution/
	 * O(N*(N + M))
	 * @param A
	 * @param B
	 * @return
	 */
	public int repeatedStringMatch(String A, String B) {
	    if(A == null || B == null || A.length() == 0 || B.length() == 0) return 0;
	    int count = 0;
	    StringBuilder sb = new StringBuilder("");
	    while(B.length() > sb.toString().length()){
	      count++;
	      sb.append(A);
	      if(sb.toString().indexOf(B) > -1) return count;
	    }
	    if(sb.append(A).toString().indexOf(B) > -1) return ++count;
	    return -1;
	  }
	
	public static void main(String[] args) {
		Prob686 prob = new Prob686();
		System.out.println(prob.repeatedStringMatch("abcd","cdabcdab"));
	}
}
