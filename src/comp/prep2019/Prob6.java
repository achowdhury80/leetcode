package comp.prep2019;

public class Prob6 {
	public String convert(String s, int numRows) {
		if (numRows < 1) return "";
		if (numRows == 1) return s;
        String[] strs = new String[numRows];
        for (int i = 0; i < strs.length; i++) strs[i] = "";
        char[] arr = s.toCharArray();
        int cur = 0;
        int dir = 1;
        for (int i = 0; i < arr.length; i++) {
        	strs[cur] += arr[i];
        	if (cur == 0) dir = 1;
        	else if (cur == numRows - 1) dir = -1;
        	cur = cur + dir * 1;
        }
        String result = "";
        for (int i = 0; i < strs.length; i++) result += strs[i];
        return result;
    }
	
	public static void main(String[] args) {
		Prob6 prob = new Prob6();
		System.out.println(prob.convert("PAYPALISHIRING", 3));
	}
}
