package comp.prep2019.less1000;

public class Prob492 {
	public int[] constructRectangle(int area) {
        int w = (int)Math.floor(Math.sqrt(area));
        while(w > 0) {
        	if (area % w == 0) return new int[] {area / w, w};
        	w--;
        }
        return null;
    }
}
