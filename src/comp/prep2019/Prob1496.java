package comp.prep2019;
import java.util.*;
public class Prob1496 {
	public boolean isPathCrossing(String path) {
        Set<Point> set = new HashSet<>();
        Point cur = new Point(0, 0);
        set.add(cur);
        Map<Character, int[]> dirs = new HashMap<>();
        dirs.put('N', new int[] {0, 1});
        dirs.put('S', new int[] {0, -1});
        dirs.put('E', new int[] {1, 0});
        dirs.put('W', new int[] {-1, 0});
        for (char c : path.toCharArray()) {
        	int[] dir = dirs.get(c);
        	cur = new Point(cur.x + dir[0], cur.y + dir[1]);
        	if (!set.add(cur)) return true;
        }
        return false;
    }
	
	class Point {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
