package comp.prep2019;
import java.util.*;
public class Prob1178 {
	public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> wBitMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
        	int mask = 0;
        	for (char c : words[i].toCharArray()) {
        		int idx = c - 'a';
        		mask |= (1 << idx);
        	}
        	wBitMap.put(mask, wBitMap.getOrDefault(mask, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (String p : puzzles) {
        	int mask = 0;
        	for (char c : p.toCharArray()) {
        		int idx = c - 'a';
        		mask |= (1 << idx);
        	}
        	int first = 1 << (p.charAt(0) - 'a');
        	int sub = mask;
        	int count = 0;
        	while(true) {
        		if ((sub & first) == first && wBitMap.containsKey(sub)) {
        			count += wBitMap.get(sub);
        		}
        		sub = (sub - 1) & mask;
        		if (sub == 0) break;
        	}
        	result.add(count);
        }
        return result;
    }
}
