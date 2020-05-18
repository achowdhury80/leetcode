package comp.prep2019;
import java.util.*;
public class Prob633 {
	public boolean judgeSquareSum(int c) {
        Set<Long> set = new HashSet<>();
        long prod = 0l;
        long i = 0;
        while((prod = i * i) <= c) {
        	if (2 * prod == c || set.contains(prod)) return true;
        	set.add(c - prod);
        	i++;
        }
        return false;
    }
}
