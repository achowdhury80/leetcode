package comp.prep2019;

public class Prob860 {
	public boolean lemonadeChange(int[] bills) {
        int fiveCont = 0, tenCount = 0;
        for (int i = 0; i < bills.length; i++) {
        	int bill = bills[i];
        	if (bill == 5) {
        		fiveCont++;
        		continue;
        	}
        	if (bill == 10) tenCount++;
        	bill -= 5;
        	if (bill >= 10 && tenCount > 0) {
        		tenCount--;
        		bill -= 10;
        	}
        	while(bill > 0 && fiveCont > 0) {
        		fiveCont--;
        		bill -= 5;
        	}
        	if (bill > 0) return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		Prob860 prob = new Prob860();
		System.out.println(prob.lemonadeChange(new int[] {5,5,5,10,20}));
	}
}
