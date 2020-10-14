package comp.prep2019;

public class Prob526 {
	public int countArrangement(int N) {
		if (N < 2) return N;
        return helper(1, new boolean[N]);
    }
	
	private int helper(int start, boolean[] used) {
		if (start > used.length) return 1;
		int result = 0;
		for (int i = 0; i < used.length; i++) {
            if (used[i] || (start % (i + 1) != 0 && (i + 1) % start != 0)) continue;
            used[i] = true;
            result += helper(start + 1, used);
            used[i] = false;
            
        }
		return result;
	}
	
	public static void main(String[] args) {
		Prob526 prob = new Prob526();
		System.out.println(prob.countArrangement(3));
	}
}
