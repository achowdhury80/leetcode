package comp.prep2019.less1000;

public class Prob925 {
	public boolean isLongPressedName(String name, String typed) {
		char[] arr = typed.toCharArray();
		int i = 0;
		for (char c : name.toCharArray()) {
        	if (i < arr.length && arr[i] == c) {
        		i++;
        		continue;
        	}
        	while(i > 0 && i < arr.length && arr[i] == arr[i - 1]) {
        		i++;
        	}
        	if (i < arr.length && arr[i] == c) {
        		i++;
        		continue;
        	}
        	return false;
        }
        while(i > 0 && i < arr.length && arr[i] == arr[i - 1]) {
        	i++;
        }
        return i == arr.length;
    }
}
