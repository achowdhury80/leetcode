package comp.prep2019.less2000;

import java.util.Arrays;

public class Prob1451 {
	public String arrangeWords(String text) {
        String[] arr = text.split(" ");
        arr[0] = arr[0].toLowerCase();
        Integer[] indices = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) indices[i] = i;
        Arrays.sort(indices, (x, y) -> arr[x].length() == arr[y].length() ? x - y 
        		: arr[x].length() - arr[y].length());
        String result = "";
        for (int i : indices) {
        	result += " " + arr[i];
        }
        result = result.substring(1);
        result = Character.toUpperCase(result.charAt(0)) + result.substring(1);
        return result;
    }
}
