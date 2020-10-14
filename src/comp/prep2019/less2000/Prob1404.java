package comp.prep2019.less2000;

public class Prob1404 {
	public int numSteps(String s) {
        if("1".equals(s)) return 0;
        if (s.charAt(s.length() - 1) == '0') {
        	int count = 0, i = s.length() - 1;
        	for (; s.charAt(i) == '0'; i--) {
            	count++;
            }
        	return count + numSteps(s.substring(0, i + 1));
        } else {
        	int i = s.length() - 1, count = 1;
        	while(i > -1 && s.charAt(i) == '1') {
        		count++;
        		i--;
        	}
        	if (i == -1) return count;
        	return count + numSteps(s.substring(0, i) + "1");
        }
        
    }
}
