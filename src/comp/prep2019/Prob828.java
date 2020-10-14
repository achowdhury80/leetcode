package comp.prep2019;
import java.util.*;
public class Prob828 {
	/**
	 * O(N) time and O(N) space
	 * In one sentence:
instead of finding the unique characters in every substring, go find all substring of every unique character.

what do you mean "every unique character"?
For each character, find the longest substring, in which the character is unique. Then this longest substring has the left and right boundary of that unique character.

example: In "CABBD", the first 'B' has a left boundary at 0 and right boundary at 3.

We can calculate the total number of substring for that 'B', by (right boundary - i) * (i - left boundary + 1) = 3; test it yourself!

For all other characters, use the formula to calculate and sum them up to get the result.
	 * @param s
	 * @return
	 */
	public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	List<Integer> list = indexMap.getOrDefault(c, new ArrayList<>());
        	list.add(i);
        	indexMap.put(c, list);
        }
        Map<Character, Integer> rightIndex = new HashMap<>();
        int result = 0;
        for (int i = s.length() - 1; i > -1; i--) {
        	char c = s.charAt(i);
        	List<Integer> list = indexMap.get(c);
        	list.remove(list.size() - 1);
        	int left = i + 1;
        	if (list.size() != 0) left = i - list.get(list.size() - 1);
        	int right = s.length() - i;
        	if (rightIndex.containsKey(c)) {
        		right = rightIndex.get(c) - i;
        	}
        	rightIndex.put(c, i);
        	result += left * right;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob828 prob = new Prob828();
		System.out.println(prob.uniqueLetterString("ABC"));
	}
}
