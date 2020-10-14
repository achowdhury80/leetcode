package comp.prep2019.less1000;

public class Prob556 {
	public int nextGreaterElement(int n) {
		if(n < 12) return -1;
        char[] arr = ("" + n).toCharArray();
        boolean modified = false;
        for (int i = arr.length - 2; i > -1; i--) {
        	char c1;
        	if ((c1 = arr[i]) < arr[i + 1]) {
        		for (int j = arr.length - 1; j > i; j--) {
        			if (arr[j] > c1) {
        				if (c1 == '0' && i == 0) continue;
        				else {
        					swap(arr, i, j);
        					modified = true;
        					reverse(arr, i + 1, arr.length - 1);
        					
        				}
        				break;
        			}
        		}
        		break;
        	}
        }
        long l;
        if (modified && (l = Long.parseLong(new String(arr))) <= Integer.MAX_VALUE) return (int)l;
        return -1;
    }
	
	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private void reverse(char[] arr, int i, int j) {
		while(i < j) {
			swap(arr, i++, j--);
		}
	}
	
	public static void main(String[] args) {
		Prob556 prob = new Prob556();
		System.out.println(prob.nextGreaterElement(12222333));
	}
}
