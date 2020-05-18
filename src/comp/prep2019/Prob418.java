package comp.prep2019;
import java.util.*;
public class Prob418 {
	public int wordsTyping(String[] sentence, int rows, int cols) {
	    String s = String.join(" ", sentence) + " ";
	    int start = 0, l = s.length();
	    for (int i = 0; i < rows; i++) {
	      start += cols;
	      if (s.charAt(start % l) == ' ') start++;
	      else while (start > 0 && s.charAt((start - 1) % l) != ' ') start--;
	    }
	    return start / l;
	  }
	
	public static void main(String[] args) {
		Prob418 prob = new Prob418();
		System.out.println(prob.wordsTyping(new String[] {"hello", "world"}, 
				2, 8));
		System.out.println(prob.wordsTyping(new String[] {"a", "bcd", "e"}, 3, 6));
	}
}
