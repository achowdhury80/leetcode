package comp.prep2019.less2000;
public class Prob1247 {
	public int minimumSwap(String s1, String s2) {
        char[] arr1 = s1.toCharArray(), arr2 = s2.toCharArray();
        int xCount = 0, xDiff = 0, yDiff = 0;
        for (int i = 0; i < arr1.length; i++) {
        	if (arr1[i] == 'x') xCount++;
        	if (arr2[i] == 'x') xCount++;
        	if (arr1[i] != arr2[i]) {
        		if (arr1[i] == 'x') xDiff++;
        		else yDiff++;
        	}
        }
        if (xCount % 2 == 1) return -1;
        int result = (xDiff / 2) + (yDiff / 2) + (xDiff % 2) + (yDiff % 2);
        return result;
    }
}
