package comp.prep2019.less1000;

public class Prob869 {
	public boolean reorderedPowerOf2(int N) {
		int tens = 1;
		int temp = N;
		while(temp > 0) {
			temp /= 10;
			tens *= 10;
		}
		int prod = 1;
		int[] arr = findDigitFreq(N);
		while(prod < tens) {
			if (prod >= tens / 10) {
				int[] arr1 = findDigitFreq(prod);
				boolean found = true;
				for (int i = 0; i < 10; i++) { 
					if (arr[i] != arr1[i]) {
						found = false;
						break;
					}
				}
				if (found) return true;
			}
			prod *= 2;
		}
		return false;
    }
	
	private int[] findDigitFreq(int N) {
		int[] arr = new int[10];
		while(N > 0) {
			arr[N % 10]++;
			N /= 10;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		Prob869 prob = new Prob869();
		System.out.println(prob.reorderedPowerOf2(46));
		System.out.println(prob.reorderedPowerOf2(10));
	}
}
