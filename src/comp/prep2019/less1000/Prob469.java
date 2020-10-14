package comp.prep2019.less1000;
import java.util.*;
public class Prob469 {
	public boolean isConvex(List<List<Integer>> points) {
	    int n;
	    if(points == null || (n = points.size()) < 3) return false;
	    int flag = 0;
	    for (int i = 0; i < n; i++) {
	      int direction = findDirection(points, i);
	      if (direction == 0) continue;
	      if (flag == 0) flag = direction > 0 ? 1 : -1;
	      else if(flag > 0 != direction > 0) return false;
	    }
	    return true;
	  }

	  /*
	   * (y1-y0)/(x1-x0) is gradient of (x0,y0) to (x1,y1)
	(y2-y1)/(x2-x1) is gradient of (x1,y1) to (x2,y2)
	Compare the two gradient to know whether it is clockwise or counter-clockwise. To avoid divide by zero, convert the equation:
	(y1-y0)/(x1-x0) = (y2-y1)/(x2-x1)
	=> (y1-y0)*((x2-x1)) = (y2-y1)*(x1-x0)
	=> (y1-y0)*((x2-x1)) - (y2-y1)*(x1-x0) =0
	If equal zero, then they are on the same line, if not, then the sign will indicate whether it is clockwise or counter-clockwise
	   */
	  private int findDirection(List<List<Integer>> points, int i) {
	    List<Integer> a = points.get(i);
	    List<Integer> b = points.get((i + 1) % points.size());
	    List<Integer> c = points.get((i + 2) % points.size());
	    return (a.get(1) - b.get(1)) * (b.get(0) - c.get(0)) - (b.get(1) - c.get(1)) * (a.get(0) - b.get(0));
	  }
}
