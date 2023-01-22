package com.prep2020.medium;

public class Problem1914 {
	public int[][] rotateGrid(int[][] grid, int k) {
		
		// number of shells possible are equivalent to half of the shorter length between row and height.
        int col=grid.length<grid[0].length? grid.length:grid[0].length;
        for(int i=1;i<=col/2;i++){
            ringrot(grid,i,k);}
        return grid;
    }
    
    //main function for making the rotation calls
    public void ringrot(int[][]arr, int ring, int rot){
        int[]oneD=twoDtooneD(arr, ring);
        
        int n=oneD.length;
		
		// we need to rotate the array in the reverse direction (from front to back. Hence, we subtract the rotation index from the array length.
		rot=n-rot;
		
		// operation to get the number in range [0,arr.length]
        rot=rot%n;
		
		// the n-r operation may have lead to a negative value of rot. Hence, we add rot to it.
        rot+=n;
		
		// operation to get the number in range [0,arr.length]
        rot%=n;
		
		// if we reverse the pre array elements (i.e. elements before the given index) and then the post array elements followed by reversing the entire array, we get the necessary rotation
        mirror(oneD,0,rot-1);
        mirror(oneD,rot,n-1);
        mirror(oneD,0,n-1);
        OneDtoTwoD(arr, oneD, ring);
    }

    // function for conversion of 2D array into 1D array
	public static int[] twoDtooneD(int [][]arr, int s){
        int sr=s-1;
        int sc=s-1;
        int n=arr.length;
        int m=arr[0].length;
        int dr=n-s;
        int dc=m-s;
        int p=0;
        int[]ans=new int[2*(m+n-4*s+2)];
        
        for(int i=sr;i<=dr;i++){
            ans[p++]=arr[i][sc];
        }
        sc++;
        
        for(int i=sc;i<=dc;i++){
            ans[p++]=arr[dr][i];
        }
        dr--;
        
        for(int i=dr;i>=sr;i--){
            ans[p++]=arr[i][dc];
        }
        dc--;
        
        for(int i=dc;i>=sc;i--){
            ans[p++]=arr[sr][i];
        }

        return ans;
    }

	// function for conversion of 1D array to 2D array
    public static void OneDtoTwoD(int[][]arr, int[]ans, int s){
        int sr=s-1;
        int sc=s-1;
        int n=arr.length;
        int m=arr[0].length;
        int dr=n-s;
        int dc=m-s;
        int p=0;
        for(int i=sr;i<=dr;i++){
            arr[i][sc]=ans[p++];
        }
        sc++;
        for(int i=sc;i<=dc;i++){
            arr[dr][i]=ans[p++];
        }
        dr--;
        for(int i=dr;i>=sr;i--){
            arr[i][dc]=ans[p++];
        }
        dc--;
        for(int i=dc;i>=sc;i--){
            arr[sr][i]=ans[p++];
        }
    }


	// function for mirroring the array about center / reversing the array
    public static void mirror(int[]arr, int sr, int dr){
        int n = arr.length;
       while(sr<dr){
            int temp = arr[sr];
            arr[sr++] = arr[dr];
            arr[dr--] = temp;
        }
    }
}
