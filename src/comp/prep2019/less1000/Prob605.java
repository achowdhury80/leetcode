package comp.prep2019.less1000;

public class Prob605 {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (n == 0) return true;
		int i = 0;
        while(n > 0 && i < flowerbed.length) {
        	if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
        		n--;
        		flowerbed[i] = 1;
        	}
        	i++;
        }
        return n == 0;
    }
}
