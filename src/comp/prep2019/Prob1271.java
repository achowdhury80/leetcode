package comp.prep2019;

public class Prob1271 {
	/**
	 * O(N) - N is length of number
	 * parse it to a long
	 * take last 4 bit
	 * if it is 0 or i set O or I
	 * if it is more than 9 set A, or B..
	 * else return error
	 * @param num
	 * @return
	 */
	public String toHexspeak(String num) {
		long l = Long.parseLong(num);
		String result = "";
		while(l > 0) {
			int i = (int)(l & ((1 << 4) - 1));
			if (i > 9) {
				result = "" + ((char)('A' + (i - 10))) + result;
			} else if (i == 0) {
				result = 'O' + result;
			} else if (i == 1) {
				result = 'I' + result;
			}else return "ERROR";
			l >>= 4;
		}
		return "".equals(result) ? "O" : result;
    }
}
