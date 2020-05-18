package comp.prep2019;

public class Prob484 {
	public int[] findPermutation(String s) {
        char[] arr = s.toCharArray();
        int incr = 1, decr = 1;
        boolean[] used = new boolean[arr.length + 1];
        int[] result = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == 'I') {
        		result[i] = incr;
        		used[incr] = true;
        		while(incr < used.length && used[incr]) incr++;;
        		decr = incr;
        	} else {
        		int j = i;
        		while(j < arr.length && arr[j] == 'D') {
        			decr++;
        			j++;
        		}
        		j--;
        		for (int k = i; k <= j; k++) {
        			result[k] = decr--;
        			if(decr < used.length - 1)
        			used[decr + 1] = true;
        		}
        		i = j;
        	}
        }
        result[result.length - 1] = incr;
        return result;
    }
	
	public static void main(String[] args) {
		Prob484 prob = new Prob484();
		//int[] result = prob.findPermutation("DDIIDI");
		int[] result = prob.findPermutation("D");
		for (int num : result) {
			System.out.print(num + ", ");
		}
	}
}
