package comp.prep2019.less1000;
import java.util.*;
public class Prob593 {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Integer, Integer> map = new HashMap<>();
        int dis = sqDistance(p1, p2);
        map.put(dis, map.getOrDefault(dis, 0) + 1);
        dis = sqDistance(p1, p3);
        map.put(dis, map.getOrDefault(dis, 0) + 1);
        dis = sqDistance(p1, p4);
        map.put(dis, map.getOrDefault(dis, 0) + 1);
        dis = sqDistance(p2, p3);
        map.put(dis, map.getOrDefault(dis, 0) + 1);
        dis = sqDistance(p2, p4);
        map.put(dis, map.getOrDefault(dis, 0) + 1);
        dis = sqDistance(p3, p4);
        map.put(dis, map.getOrDefault(dis, 0) + 1);
        if (map.keySet().size() != 2) return false;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	if (entry.getValue() != 4 && entry.getValue() != 2) return false;
        }
        return true;
    }
	
	private int sqDistance(int[] x, int[] y) {
		return (x[0] - y[0]) * (x[0] - y[0]) + (x[1] - y[1]) * (x[1] - y[1]); 
	}
}
