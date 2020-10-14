package comp.prep2019.less2000;

public class Prob1427 {
	public String stringShift(String s, int[][] shift) {
		int amount = 0;
        for (int[] arr : shift) {
        	if (arr[0] == 0) amount -= arr[1];
        	else amount += arr[1];
        }
        int dir = amount <= 0 ? 0 : 1;
        amount = Math.abs(amount) % s.length();
        return amount == 0 ? s : shift(s, dir, amount);
    }
	
	private String shift(String s, int dir, int amount) {
		return dir == 0 ? s.substring(amount) + s.substring(0, amount) 
			: s.substring(s.length() - amount) + s.substring(0, s.length() - amount) ;
	}
}
