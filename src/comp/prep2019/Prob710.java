package comp.prep2019;
import java.util.*;
public class Prob710 {
	private int N;
	private TreeMap<Integer, Integer> treeMap;
	private Random random;
	public Prob710(int N, int[] blacklist) {
		treeMap = new TreeMap<>();
		Arrays.sort(blacklist);
		int count = 0;
        for (int i : blacklist) treeMap.put(i, ++count);
        this.N = N;
        random = new Random();
    }
    
    public int pick() {
        int randomValue = random.nextInt(N - treeMap.size());
        int start = randomValue, end = N - 1;
        while(start < end) {
        	int mid = start + (end - start) / 2;
        	Map.Entry<Integer, Integer> entry = treeMap.floorEntry(mid);
        	int size = entry == null ? 0 : entry.getValue();
        	if (size + randomValue == mid)  {
        		if (treeMap.containsKey(mid)) end = mid - 1;
        		else return mid;
        	}
        	else if (size + randomValue < mid) end = mid - 1;
        	else start = mid + 1;
        }
        return start;
    }
    
    public static void main(String[] args) {
    	Prob710 prob = new Prob710(3, new int[] {1});
    	System.out.println(prob.pick());
    }
}
