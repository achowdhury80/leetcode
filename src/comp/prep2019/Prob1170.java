package comp.prep2019;
import java.util.*;
public class Prob1170 {
	public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] arr = new int[words.length];
        for (int i = 0; i < words.length; i++) arr[i] = f(words[i]);
        Arrays.sort(arr);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int sum = 0;
        for (int i = arr.length - 1; i > -1; i--) {
        	int key = arr[i];
        	sum++;
        	map.put(key, sum);
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
        	int qLen = f(queries[i]);
        	Map.Entry<Integer, Integer> entry = map.higherEntry(qLen);
        	if (entry != null) result[i] = entry.getValue();
        }
        return result;
    }
	
	public int f(String w) {
		int[] arr = new int[26];
		char min = (char)('z' + 1);
		for (char c : w.toCharArray()) {
			if (c < min) min = c;
			arr[c - 'a']++;
		}
		return arr[min - 'a'];
	}
	
	public static void main(String[] args) {
		Prob1170 prob = new Prob1170();
		int[] arr = prob.numSmallerByFrequency(new String[] {"bbb", "cc"}, 
				new String[] {"a","aa", "aaa", "aaaa"});
		for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + ", ");
	}
}
