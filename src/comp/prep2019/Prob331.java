package comp.prep2019;

public class Prob331 {
	public boolean isValidSerialization(String preorder) {
		int[] next = new int[1];
		String[] arr = preorder.split(",");
		return verify(arr, 0, next) && next[0] == arr.length;
    }
	
	private boolean verify(String[] arr, int start, int[] next) {
		if(start == arr.length) return false;
		if (arr[start].equals("#")) {
			next[0] = start + 1;
			return true;
		}
		if (!verify(arr, start + 1, next)) return false;
		return verify(arr, next[0], next);
	}
	
	public static void main(String[] args) {
		Prob331 prob = new Prob331();
		System.out.println(prob.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
	}
}
