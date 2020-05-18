package comp.prep2019;


public class Prob777 {
	public boolean canTransform(String start, String end) {
	    int i = 0, j = 0, n = Math.min(start.length(), end.length());
	    while (i < n && j < n) {
	      while (i < n && start.charAt(i) == 'X') i++;
	      while (j < n && end.charAt(j) == 'X') j++;
	      if (i == n && j == n) break;
	      // start[i] != X and end[j] != X. meaning they have to be equal
	      if (i == n || j == n || start.charAt(i) != end.charAt(j)) return false;
	      // start[i] = R, meaning it can go right but not left
	      if (start.charAt(i) == 'R' && i > j) return false;
	   // start[i] = L, meaning it can go left but not right
	      if (start.charAt(i) == 'L' && j > i) return false;
	      i++;
	      j++;
	    }
	    return true;
	  }

	  public static void main(String[] args) {
	    Prob777 prob777 = new Prob777();
	    System.out.println(prob777.canTransform("RXXLRXRXL", "XRLXXRRLX"));
	    System.out.println(prob777.canTransform("XRXXLXLXXXXRXXXXLXXL", "XXRXLXXLXXRLXXXLXXXX"));

	  }
}
