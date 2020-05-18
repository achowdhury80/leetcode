package comp.prep2019;

public class Prob1108 {
	/**
	 * O(N)
	 * @param address
	 * @return
	 */
	public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
        	if (c == '.') sb.append("[.]");
        	else sb.append(c);
        }
        return sb.toString();
    }
}
