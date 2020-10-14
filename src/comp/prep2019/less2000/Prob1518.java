package comp.prep2019.less2000;

public class Prob1518 {
	public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        int empty = numBottles;
        while(empty >= numExchange) {
        	int full = empty / numExchange;
        	empty %= numExchange;
        	result += full;
        	empty += full;
        }
        return result;
    }
}
