package comp.prep2019.less2000;

import java.util.Arrays;

public class Prob1465 {
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int maxHeight = 0, maxWidth = 0;
        Arrays.sort(horizontalCuts);
        int last = 0;
        for (int i : horizontalCuts) {
        	maxHeight = Math.max(maxHeight, i - last);
        	last = i;
        }
        maxHeight = Math.max(maxHeight, h - last);
        Arrays.sort(verticalCuts);
        last = 0;
        for (int i : verticalCuts) {
        	maxWidth = Math.max(maxWidth, i - last);
        	last = i;
        }
        maxWidth = Math.max(maxWidth, w - last);
        return (int)((1l * maxHeight * maxWidth) % (1e9 + 7));
    }
}
