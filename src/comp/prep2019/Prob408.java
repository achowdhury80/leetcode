package comp.prep2019;

public class Prob408 {
	public boolean validWordAbbreviation(String word, String abbr) {
        int idx = 0;
        char[] arr = abbr.toCharArray();
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
        	if (Character.isLetter(arr[i])) {
        		if (num > 0) {
        			if (idx + num > word.length()) return false;
        			idx += num;
        			num = 0;
        		}
        		if (idx == word.length() || arr[i] != word.charAt(idx)) return false;
        		idx++;
        	} else {
        		num = num * 10 + (arr[i] - '0'); 
        		if (num == 0) return false;
        	}
        }
        if (num > 0) {
			if (idx + num > word.length()) return false;
			idx += num;
		} 
        return idx == word.length();
    }
	
	public static void main(String[] args) {
		Prob408 prob = new Prob408();
		System.out.println(prob.validWordAbbreviation("internationalization","i12iz4n"));
	}
}
