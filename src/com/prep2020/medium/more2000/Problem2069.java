package com.prep2020.medium.more2000;

public class Problem2069 {
	int p;
    int w;
    int h;
    public Problem2069(int width, int height) {
        w = width - 1;
        h = height - 1;
        p = 0;
    }

    public void step(int num) {
        p += num;
    }

    public int[] getPos() {
        int remain = p % (2 * (w + h));
        if (remain <= w)
            return new int[]{remain, 0};
        remain -= w;
        if (remain <= h)
            return new int[]{w, remain};
        remain -= h;
        if (remain <= w)
            return new int[]{w - remain, h};
        remain -= w;
        return new int[]{0, h - remain};
    }

    public String getDir() {
        int[] pos = getPos();
        if (p == 0 || pos[1] == 0 && pos[0] > 0)
            return "East";
        else if (pos[0] == w && pos[1] > 0)
            return "North";
        else if (pos[1] == h && pos[0] < w)
            return "West";
        else
            return "South";
    }
    
}
