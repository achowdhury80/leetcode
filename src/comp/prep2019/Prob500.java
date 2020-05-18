package comp.prep2019;
import java.util.*;
public class Prob500 {
	public String[] findWords(String[] words) {
	    if(words == null || words.length == 0) return new String[0];
	    List<String> list = new ArrayList<>();
	    String[] rows = new String[] {"qwertyuiop", "asdfghjkl]", "zxcvbnm"};
	    for (String w : words) {
	    	char[] arr = w.toLowerCase().toCharArray();
	    	int last = -1;
	    	for (int i = 0; i < rows.length; i++) {
	    		if(rows[i].indexOf(arr[0]) > -1) {
	    			last = i; 
	    			break;
	    		}
	    	}
	    	boolean flag = true;
	    	for (int i = 1; i < arr.length; i++) {
	    		if (rows[last].indexOf(arr[i]) < 0) {
	    			flag = false;
	    			break;
	    		}
	    	}
	    	if(flag) list.add(w);
	    }
	    return list.toArray(new String[0]);
	  }
	
	public static void main(String[] args) {
		Prob500 prob = new Prob500();
		System.out.println(prob.findWords(new String[] {"Hello","Alaska","Dad",
				"Peace"}));
	}
}
