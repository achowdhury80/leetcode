package comp.prep2019;

public class Prob733 {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	    if(image == null || image.length == 0 || image[0] == null || image[0].length == 0) return image;
	    if(image[sr][sc] == newColor) return image;
	    return fill(image, sr, sc, image[sr][sc], newColor);
	  }

	  private int[][] fill(int[][] image, int sr, int sc, int color, int newColor) {
	    if(sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == color) {
	      image[sr][sc] = newColor;
	    } else return image;
	    fill(image, sr + 1, sc, color, newColor);
	    fill(image, sr - 1, sc, color, newColor);
	    fill(image, sr, sc + 1, color, newColor);
	    fill(image, sr, sc - 1, color, newColor);
	    return image;
	  }
}	
