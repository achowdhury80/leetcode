package comp.prep2019;
import java.util.*;
public class Prob1215 {
	public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            helper((long)low, (long)high, i, res);
        }
        Collections.sort(res);
        
        return res;
    }
    
    public void helper(long low, long high, long cur, List<Integer> res) {
        if (cur > high) return;
        
        if (cur >= low) res.add((int)cur);
        if (cur == 0) return;
        
        long last = cur % 10;
        if (last > 0) helper(low, high, cur * 10 + last - 1, res);
        if (last < 9) helper(low, high, cur * 10 + last + 1, res); 
    }
}
