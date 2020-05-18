package comp.prep2019;
public class Prob1073 {
	public int[] addNegabinary(int[] arr1, int[] arr2) {
		reverse(arr1);
		reverse(arr2);
		int[] result = new int[Math.max(arr1.length, arr2.length) + 4];
		int i = 0;
		while(i < arr1.length && i < arr2.length) {
			result[i] = arr1[i] + arr2[i];
			i++;
		}
		while(i < arr1.length) {
			result[i] = arr1[i];
			i++;
		}
		while(i < arr2.length) {
			result[i] = arr2[i];
			i++;
		}
		for (i = 0; i < result.length; i++) {
			//combination .......12...... can be replaced with .......00......
            //for ex. :  1*16 - 2*8  
            //for ex. :  1*-32 + 2*16
			if (result[i] == 2 && result[i + 1] == 1) {
				result[i] = 0;
				result[i + 1] = 0;
			} else if (result[i] == 2 || result[i] == 3) {
				//value .......2.......  can be reaplced with  .....110.......
	            //for ex. :   2*4 = 1*16 + 1*-8  
	            //for ex. :   2*-8 = 1*-32 + 1*16 
	            //value .......3.......  can be reaplced with  .....111.......
				result[i + 1]++;
				result[i + 2]++;
				result[i] -= 2;
			} else if (result[i] == 4) {
				result[i + 2]++;
				result[i] = 0;
			}
		}
		reverse(result);
		for (i = 0; i < result.length && result[i] == 0; i++);
		if (i == result.length) return new int[] {0};
		int[] arr = new int[result.length - i];
		for (int j = 0; j < arr.length; j++, i++) {
			arr[j] = result[i];
		}
		return arr;
        
     }
	private void reverse(int[] arr) {
		int i = 0, j = arr.length - 1;
		while(i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
	
	public static void main(String[] args) {
		Prob1073 prob = new Prob1073();
		int[] result = prob.addNegabinary(new int[] {1,1,1,1,1}, new int[] {1,0,1});
		for (int i = 0; i < result.length; i++) System.out.print(result[i] + ", ");
	}
}
