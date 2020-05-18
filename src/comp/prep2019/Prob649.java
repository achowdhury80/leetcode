package comp.prep2019;

public class Prob649 {
	public String predictPartyVictory(String senate) {
		char[] arr = senate.toCharArray();
		int i = 0;
        while(true) {
        	if (arr[i] !='0' && !removeNext(arr, i)) return arr[i] == 'R' ? "Radiant" : "Dire";
        	i = (i + 1) % arr.length; 
        }
    }
	
	private boolean removeNext(char[] arr, int i) {
		int j = (i + 1) % arr.length;
		while(j != i) {
			if (arr[j] != arr[i] && arr[j] != '0') {
				arr[j] = '0';
				return true;
			}
			j = (j + 1) % arr.length;
		}
		return false;
	}
}
