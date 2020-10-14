package comp.prep2019;

public class Prob1523 {
	public int countOdds(int low, int high) {
        int total = high - low + 1;
        return total % 2 == 0 ? total / 2 
        		: (low % 2 == 1 ? (total + 1) / 2 : total / 2);
    }
}
