package comp.prep2019.less1000;

public class Prob838 {
	
	public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int start = 0;
        int lastRIndex = -1;
        for (int i = 0; i < dominoes.length(); i++) {
            char c = dominoes.charAt(i);
            if (c == 'L') {
                if (lastRIndex == -1) {
                    fill(arr, start, i, c);
                    start = i + 1;
                } else {
                    fill(arr, lastRIndex, lastRIndex + (i - lastRIndex - 1) / 2, 'R');
                    fill(arr, i - (i - lastRIndex - 1) / 2, i, 'L');
                    start = i + 1;
                    lastRIndex = -1;
                }
            } else if (c == 'R') {
                if (lastRIndex != -1) fill(arr, lastRIndex, i - 1, 'R');
                lastRIndex = i;
            }
        }
        if (lastRIndex != -1) fill(arr, lastRIndex, arr.length - 1, 'R');
        return new String(arr);
        
    }
	
	private void fill(char[] arr, int i, int j, char c) {
        for (int k = i; k <= j; k++
        		) arr[k] = c;
    }
	public String pushDominoes1(String dominoes) {
        char[] arr = dominoes.toCharArray();
        for (int i = 0; i < arr.length; i++) {
        	int start = -1;
        	if (arr[i] == 'L') {
        		start = i;
        		for (int j = i - 1; j > -1; j--) {
        			if (arr[j] != '.') {
        				break;
        			} else start = j;
        		}
        		move(arr, start, i, 'L');
        	} else if (arr[i] == 'R') {
        		for (int j = i + 1; j < arr.length; j++) {
        			if (arr[j] == 'L') {
        				int gap = j - i;
        				if (gap % 2 == 1) {
        					move(arr, i, i + gap / 2, 'R');
        					move(arr, i + gap / 2 + 1, j, 'L');
        				} else {
        					move(arr, i, i + gap / 2 - 1, 'R');
        					move(arr, i + gap / 2 + 1, j, 'L');
        				}
        				i = j;
        				break;
        			} else if (arr[j] == 'R') {
        				move(arr, i, j - 1, 'R');
        				i = j - 1;
        				break;
        			} else if (j == arr.length - 1) {
        				move(arr, i, arr.length - 1, 'R');
        				i = j;
        			}
        		}
        	}
        }
        return new String(arr);
    }
	
	private void move(char[] arr, int start, int end, char c) {
		for (int i = start; i <= end; i++) arr[i] = c;
	}
	
	public static void main(String[] args) {
		Prob838 prob = new Prob838();
		//System.out.println(prob.pushDominoes(".L.R...LR..L.."));
		System.out.println(prob.pushDominoes("RR.L"));
	}
}
