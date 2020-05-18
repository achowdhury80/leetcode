package comp.prep2019;

public class Prob670 {
	public int maximumSwap(int num) {
        char[] arr = ("" + num).toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
        	int c = arr[i];
        	int pos = -1;
        	for (int j = i + 1; j < arr.length; j++) {
        		if (c < arr[j]) {
        			if (pos == -1 || arr[pos] <= arr[j])
        			pos = j;
        		}
        	}
        	if (pos > -1) {
        		char t = arr[i];
        		arr[i] = arr[pos];
        		arr[pos] = t;
        		return Integer.valueOf(new String(arr));
        	}
        }
        return num;
    }
	
	public static void main(String[] args) {
		Prob670 prob = new Prob670();
		System.out.println(prob.maximumSwap(2736));
	}
}
