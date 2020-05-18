package comp.prep2019;

public class Prob604 {
	private char lastChar;
	private int count = 0, idx = 0;
	private char[] arr;
	public Prob604(String compressedString) {
        arr = compressedString.toCharArray();
        if (idx >= arr.length) return;
        lastChar = arr[idx++];
        int i = idx;
        while(i < arr.length && Character.isDigit(arr[i])) {
        	count = count * 10 + (arr[i] - '0');
        	i++;
        }
        idx = i;
    }
    
    public char next() {
    	if (!hasNext()) return ' ';
        char c = lastChar;
        count--;
        if (count == 0 && idx < arr.length) {
        	lastChar = arr[idx++];
            int i = idx;
            while(i < arr.length && Character.isDigit(arr[i])) {
            	count = count * 10 + (arr[i] - '0');
            	i++;
            }
            idx = i;
        }
        return c;
    }
    
    public boolean hasNext() {
        return count > 0 || idx < arr.length;
    }
}
