package comp.prep2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob963 {
	/**
	 * O(N^2)
	 * find all pairwise distance, their center
	 * put in a map where key is center(string representation)
	 * and value is another map. That map will contain distance as key and points as distance
	 * now for each center and each distance, there are more than 3 points, then you are at diagonal intersection
	 * In the list, the points are arranged in the order a,c,b,d if rectangle is a,b,c,d
	 * find ab and cd. compute ab*cd and keep track of min
	 * 
	 * @param points
	 * @return
	 */
	public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        Map<String, Map<Double, List<int[]>>> map = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++) {
        	for (int j = i + 1; j < points.length; j++) {
        		double centerX = ((double)points[i][0] + points[j][0]) / 2;
                double centerY = ((double)points[i][1] + points[j][1]) / 2;
                double dist = ((double)points[i][0] - points[j][0]) * 
                		(points[i][0] - points[j][0]) + 
                		(points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                String str = centerX + " " + centerY;
                map.putIfAbsent(str, new HashMap<>());
                map.get(str).putIfAbsent(dist, new ArrayList<>());
                map.get(str).get(dist).add(points[i]); 
                map.get(str).get(dist).add(points[j]);
        	}
        }
        double min = Double.MAX_VALUE;
        for (String c : map.keySet()) {
            for (double d : map.get(c).keySet()) {
                List<int[]> list = map.get(c).get(d);
                if (list.size() >= 4) {
                    for (int i = 0; i + 2 < list.size(); i += 2) {
                        for (int j = i + 2; j + 1 < list.size(); j += 2) {
                            double dist1 = Math.sqrt(((double)list.get(i)[0] - list.get(j)[0]) 
                            		* ((double)list.get(i)[0] - list.get(j)[0]) 
                            		+ ((double)list.get(i)[1] - list.get(j)[1]) 
                            		* ((double)list.get(i)[1] - list.get(j)[1]));
                            double dist2 = Math.sqrt(((double)list.get(i)[0] - list.get(j + 1)[0]) 
                            		* ((double)list.get(i)[0] - list.get(j + 1)[0]) 
                            		+ ((double)list.get(i)[1] - list.get(j + 1)[1]) 
                            		* ((double)list.get(i)[1] - list.get(j + 1)[1]));
                            min = Math.min(dist1 * dist2, min);
                        }
                    }
                }
            }
        }
        return min == Double.MAX_VALUE ? 0 : min;
    }
}
