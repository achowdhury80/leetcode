package comp.prep2019.less1000;

public class Prob50 {
	public double myPow(double x, int n) {
		if (n == 0) return 1;
        if (n == 1) return x;
        if (n == Integer.MIN_VALUE) return 0;
		if (n < 0) {
			x = (1 / x);
			n *= (-1);
		}
        return myPow(x * x, n / 2) * myPow(x, n % 2);
    }
	
	public static void main(String[] args) {
		Prob50 prob = new Prob50();
		System.out.println(prob.myPow(1.00000, -2147483648));
	}
}
