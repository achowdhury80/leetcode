package comp.prep2019;

public class Prob1417 {
	public String reformat(String s) {
        StringBuilder[] sbs = new StringBuilder[] {new StringBuilder(), 
        		new StringBuilder()};
        for (char c : s.toCharArray()) {
        	if (c >= 'a' && c <= 'z') sbs[0].append(c);
        	else sbs[1].append(c);
        }
        StringBuilder result = new StringBuilder();
        int idx = sbs[0].length() > sbs[1].length() ? 0 : 1;
        while(sbs[0].length() > 0 || sbs[1].length() > 0) {
        	if (sbs[idx].length() == 0) return "";
        	result.append(sbs[idx].charAt(0));
        	sbs[idx].deleteCharAt(0);
        	idx = (idx + 1) % 2;
        }
        return result.toString();
    }
}
