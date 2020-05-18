package comp.prep2019;

public class Prob537 {
	public String complexNumberMultiply(String a, String b) {
        int[] c1 = parse(a);
        int[] c2 = parse(b);
        return "" + (c1[0] * c2[0] - c1[1] * c2[1]) + "+" + (c1[0] * c2[1] + c1[1] * c2[0]) + "i";
    }
	
	private int[] parse(String s) {
		String[] arr = s.split("\\+");
		return new int[] {Integer.valueOf(arr[0]), Integer.valueOf(arr[1].substring(0, arr[1].indexOf("i")))};
	}
}
