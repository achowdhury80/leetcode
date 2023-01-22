package com.prep2020.medium;

public class Problem1618 {
	/**
	 * O(logN)
	 * @param text
	 * @param w
	 * @param h
	 * @param fonts
	 * @param fontInfo
	 * @return
	 */
	public int maxFont(String text, int w, int h, int[] fonts, 
			FontInfo fontInfo) {
         int maxFontIndexBasedOnHeight = findMaxFontSizeByheight(h, fonts, fontInfo);
         if (maxFontIndexBasedOnHeight == -1) return -1;
         int result = -1, low = 0, high = maxFontIndexBasedOnHeight;
         while(low <= high) {
        	 int mid = low + (high - low) / 2;
        	 int sum = findWidth(text, fonts[mid], fontInfo);
        	 if (sum > w) high = mid - 1;
        	 else {
        		 result = fonts[mid];
        		 low = mid + 1;
        	 }
         }
         return result;
         
    }
	
	private int findWidth(String text, int font, FontInfo fontInfo) {
		int sum = 0;
		for (char c : text.toCharArray()) {
			sum += fontInfo.getWidth(font, c);
		}
		return sum;
	}
	
	private int findMaxFontSizeByheight(int h, int[] fonts, FontInfo fontInfo) {
		int result = -1;
		int low = 0, high = fonts.length - 1;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			int height = fontInfo.getHeight(fonts[mid]);
			if (height > h) high = mid - 1;
			else {
				result = mid;
				low = mid + 1;
			}
		}
		return result;
	}
	
	interface FontInfo {
		      // Return the width of char ch when fontSize is used.
		      public int getWidth(int fontSize, char ch);
		      // Return Height of any char when fontSize is used.
		      public int getHeight(int fontSize);
		  }
}
