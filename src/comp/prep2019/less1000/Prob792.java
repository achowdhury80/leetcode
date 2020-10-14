package comp.prep2019.less1000;
import java.util.*;
public class Prob792 {
	public int numMatchingSubseq(String S, String[] words) {
        TreeSet<Integer>[] arr = new TreeSet[26];
        char[] sArr = S.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
        	if (arr[sArr[i] - 'a'] == null) arr[sArr[i] - 'a'] = new TreeSet<>();
        	arr[sArr[i] - 'a'].add(i);
        }
        int result = 0;
        for (String w : words) {
        	int k = -1;
        	boolean found = true;
        	for (char c : w.toCharArray()) {
        		if (arr[c - 'a'] == null || arr[c - 'a'].higher(k) == null) {
        			found = false;
        			break;
        		} else k = arr[c - 'a'].higher(k);
        	}
        	if(found) result++;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob792 prob = new Prob792();
		System.out.println(prob.numMatchingSubseq("dsahjpjauf", new String[] {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}));
	}
}
