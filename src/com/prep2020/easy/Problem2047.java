package com.prep2020.easy;

public class Problem2047 {
	/**
	 * O(N)
	 * @param sentence
	 * @return
	 */
	/*public int countValidWords(String sentence) {
        String[] ws = sentence.split(" ");
        int result = 0;
        for (String w : ws) {
        	if (!"".equals(w) && isValid(w)) result++;
        }
        return result;
    }

	private boolean isValid(String w) {
		int len = w.length();
		boolean hyphenExists = false, punctuationExists = false;
		for (int i = 0; i < len; i++) {
			char c = w.charAt(i);
			if (c == '-') {
				if (i == 0 || i == len - 1 || hyphenExists) return false;
				hyphenExists = true;
			} else if ("!.,".indexOf(c) > -1) {
				if (i != len - 1 || punctuationExists) return false;
				punctuationExists = true;
			} else if (c < 'a' || c > 'z') return false;
		}
		return true;
	}*/
	
	public int countValidWords(String sentence) {
        int n = sentence.length();
        
        int count = 0;
        int i = 0;
        while(i < n){
            if(sentence.charAt(i) == ' '){ i++; continue; };
            
            // Get the word
            int j = i+1;
            while(j < n && sentence.charAt(j) != ' ' ) j++;
            
            String temp = sentence.substring(i, j);
            if(isValid(temp) == true){
                count++;
            }

            i = j;
        }
        
        return count;
    }
    
    private boolean isValid(String temp){
        
        boolean flag = false;
        for(int i=0; i<temp.length(); i++){
            char c = temp.charAt(i);
            
            // Uppercase and digit not allowed
            if(Character.isUpperCase(c)) return false;
            else if(Character.isDigit(c)) return false;
            
            if(c == '-'){
                if(flag == true) return false;
                if(i == 0 || i == temp.length()-1) return false; // On the bounds
                
                if(!( Character.isLowerCase(temp.charAt(i-1)) && Character.isLowerCase(temp.charAt(i+1)) )) return false;
                flag = true;
            }
            else if(c == '!' || c == ',' || c == '.'){
                if(i != temp.length()-1) return false;
            }
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		Problem2047 problem = new Problem2047();
		System.out.println(problem.countValidWords("cat and  dog"));
	}
}
