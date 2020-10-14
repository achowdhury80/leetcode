package comp.prep2019.less1000;

public class Prob917 {
	public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int i = 0, j = arr.length - 1;
        while(i < j) {
        	if(!Character.isLetter(arr[i])) i++;
        	else if(!Character.isLetter(arr[j])) j--;
        	else {
        		char temp = arr[i];
        		arr[i] = arr[j];
        		arr[j] = temp;
        		i++;
        		j--;
        	}
        }
        return new String(arr);
    }
}
