package comp.prep2019;

public class Prob1359 {
	/**
	 * lets say we have solved for n = 2
	 * now for the third one we have 5 places (2 places at both end and 3 internal places
	 * so, for if we place p3 at leftmost end, then we have 5 places for D3, if we place after 1st, we have 4 places for d3.. so on
	 * so given t places filed up, we have (t + 1) + t + (t - 1) + ... + 1 options
	 * @param n
	 * @return
	 */
	public int countOrders(int n) {
        int mod = (int)(1e9 + 7);
        int count = 2; // considering n = 1, there will be two elements P1 and D1
        long result = 1; // considering n = 1;
        for (int i = 1; i < n; i++) {
        	int elements = i * count;
        	long sum = ((elements + 1l) * (elements + 2)) / 2;
        	result = (result * sum) % mod;
        }
        return (int)result;
    }
	
	public static void main(String[] args) {
		Prob1359 prob = new Prob1359();
		System.out.println(prob.countOrders(8));
	}
}
