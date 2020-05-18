package comp.prep2019;
import java.util.*;
public class Prob395 {
	public int longestSubstring(String s, int k) {
	    if(s == null || s.length() < 0) return 0;
	    if(k < 2) return s.length();
	    if(k > s.length()) return 0;
	    int[] charMap = new int[26];
	    return longest(s.toCharArray(), 0, s.length() - 1, k);
	  }
	  private int longest(char[] chars, int start, int end, int k){
	    if(end - start + 1 < k) {
	      return 0;
	    }
	    int[] charMap = new int[26];
	    for(int i = start; i <= end; i++) charMap[chars[i] - 'a']++;
	    for(int i = 0; i < 26; i++){
	      if(charMap[i] != 0 && charMap[i] < k){
	        for(int j = start; j <= end; j++){
	          if(chars[j] - 'a' == i){
	            int leftMax = 0;
	            if(j != start){
	              leftMax = longest(chars, start, j - 1, k);
	            }
	            int rightMax = 0;
	            if(j != end){
	              rightMax = longest(chars, j + 1, end, k);
	            }
	            return Math.max(leftMax, rightMax);
	          }
	        }
	      }
	    }
	    return end - start + 1;
	  }
}
