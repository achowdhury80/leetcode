package comp.prep2019.less1000;

public class Prob299 {
	public String getHint(String secret, String guess) {
        int b = 0, c = 0;
        int[] charMap = new int[10];
        for (int i = 0; i < secret.length(); i++) {
        	char c1 = secret.charAt(i);
        	char c2 = guess.charAt(i);
        	if (c1 == c2) {
        		b++;
        	} else {
        		if (charMap[c1 - '0'] < 0) {
        			c++;
        		}
        		charMap[c1 - '0']++;
        		if (charMap[c2 - '0'] > 0) {
        			c++;
        		}
        		charMap[c2 - '0']--;
        	}
        }
        return b + "A" + c + "B";
    }
}
