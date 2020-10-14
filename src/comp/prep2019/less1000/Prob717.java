package comp.prep2019.less1000;

public class Prob717 {
	public boolean isOneBitCharacter(int[] bits) {
		int i = 0;
		boolean oneBit = bits[i] == 0;
		if (oneBit) i++;
		else i += 2;
        while(i < bits.length) {
        	if (bits[i] == 0) {
        		oneBit = true;
        		i++;
        	} else {
        		oneBit = false;
        		i += 2;
        	}
        }
        return oneBit;
    }
}
