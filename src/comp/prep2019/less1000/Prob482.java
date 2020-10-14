package comp.prep2019.less1000;

public class Prob482 {
	public String licenseKeyFormatting(String S, int K) {
        char[] arr = S.toCharArray();
        int count = 0;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
        	char c = arr[arr.length - i -1];
        	if (c != '-') {
        		count++;
        		sb.insert(0, Character.toUpperCase(c));
        		if(count == K) {
        			sb.insert(0, '-');
        			count = 0;
        		}
        	}
        }
        if(sb.length() > 0 && sb.charAt(0) == '-') sb.deleteCharAt(0);
        return sb.toString();
    }
	
	public static void main(String[] args) {
		Prob482 prob = new Prob482();
		System.out.println(prob.licenseKeyFormatting("5F3Z-2e-9-w",
				4));
	}
}
