package comp.prep2019.less1000;

public class Prob424 {
	public int characterReplacement(String s, int k) {
	    if(s == null || s.length() < 1) return 0;
	    int[] count = new int[26];
	    int end = 0, start = 0, len = s.length();
	    int maxCount = 0, maxLength = 0;
	    for(end = 0; end < len; end++){
	      maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
	      if (end - start + 1 - maxCount > k){
	    	  // this is tricky
	        count[s.charAt(start) - 'A']--;
	        start++;
	      }
	      maxLength = Math.max(maxLength, end - start + 1);
	    }
	    return maxLength;
	  }
}
