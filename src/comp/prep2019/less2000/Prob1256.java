package comp.prep2019.less2000;
public class Prob1256 {
	public String encode(int num) {
		if (num  < 3) return new String[] {"", "0", "1"}[num];
		int n = 2, bit = 1, count = 2;
		while(count + 2 * n <= num) {
			bit++;
			n *= 2;
			count += n;
		}
		StringBuilder sb = new StringBuilder();
        if (count == num) {
        	for (int i = 0; i < bit; i++) sb.append("1");
        	return sb.toString();
        }
        if (num - count <= n) sb.append("0");
        else sb.append("1");
        for (int i = 0; i < bit; i++) sb.append("0");
        String str = encode(num - n);
        for (int i = 0; i < str.length(); i++) {
        	if (str.charAt(str.length() - i - 1) == '1') {
        		sb.setCharAt(sb.length() - i - 1, '1');
        	}
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		Prob1256 prob = new Prob1256();
		System.out.println(prob.encode(107));
		//System.out.println(prob.encode(12));
	}
}
