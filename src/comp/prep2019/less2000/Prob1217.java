package comp.prep2019.less2000;
public class Prob1217 {
	public int minCostToMoveChips(int[] chips) {
        int odd = 0, even = 0;
        for (int chip : chips) {
        	if (chip % 2 == 0) even++;
        	else odd++;
        }
        return Math.min(odd, even);
    }
	
	public static void main(String[] args) {
		Prob1217 prob = new Prob1217();
		System.out.println(prob.minCostToMoveChips(new int[] {2, 2, 2, 3, 3}));
		System.out.println(prob.minCostToMoveChips(new int[] {6,4,7,8,2,10,2,7,9,7}));
		
	}
}
