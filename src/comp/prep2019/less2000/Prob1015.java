package comp.prep2019.less2000;
import java.util.*;
public class Prob1015 {
	public int smallestRepunitDivByK(int K) {
		int cur = 0;
		int result = 0;
		Set<Integer> visited = new HashSet<>();
        while(!visited.contains(cur * 10 + 1)) {
        	result++;
        	cur = cur * 10 + 1;
        	visited.add(cur);
        	cur = cur % K;
        	if(cur == 0) return result;
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Prob1015 prob = new Prob1015();
		System.out.println(prob.smallestRepunitDivByK(3));
	}
}
