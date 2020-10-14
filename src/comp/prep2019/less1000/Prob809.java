package comp.prep2019.less1000;

public class Prob809 {
	public int expressiveWords(String S, String[] words) {
	    int result = 0;
	    for (String w : words) {
	      int i, j = 0;
	      for (i = 0; i < S.length(); i++) {
	        if (j < w.length() && w.charAt(j) == S.charAt(i)) j++;
	        else if (i > 0 && S.charAt(i - 1) == S.charAt(i) && i < S.length() - 1 && S.charAt(i) == S.charAt(i + 1)) i++;
	        else if (!(i > 1 && S.charAt(i - 2) == S.charAt(i - 1) && S.charAt(i - 1) == S.charAt(i))) break;
	      }
	      if (i == S.length() && j == w.length()) result++;
	    }
	    return result;
	  }
	
	public static void main(String[] args) {
		Prob809 prob = new Prob809();
		/*System.out.println(prob.expressiveWords("heeellooo",
				new String[] {"hello", "hi", "helo"}));*/
		
		System.out.println(prob.expressiveWords("dddiiiinnssssssoooo",
				new String[] {"ddiinnso"}));
		
		//"dddiiiinnssssssoooo"
		//["dinnssoo","ddinso","ddiinnso","ddiinnssoo","ddiinso","dinsoo","ddiinsso","dinssoo","dinso"]
	}
}
