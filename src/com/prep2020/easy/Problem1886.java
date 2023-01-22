package com.prep2020.easy;

public class Problem1886 {
	public boolean findRotation(int[][] mat, int[][] target)    {
        for(int i=0;i<4;i++) {
            if(isRotate(mat,target))
                return true;
            rotate(mat);
        }
        return false;
    }
    public boolean isRotate(int[][] mat, int[][] target){
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                if(mat[i][j]!=target[i][j])
                    return false;
            }
            
        }
       return true; 
    }
    //rotate = transpose + reverse
    public boolean rotate(int[][] mat) {
        //transpose
        for(int i=0;i<mat.length;i++) {
            for(int j=i;j<mat[i].length;j++) {
                if(i!=j) {
                    int temp = mat[i][j];
                    mat[i][j]=mat[j][i];
                    mat[j][i]=temp;
                }
            }
        }
        //reverse
        for(int i=0;i<mat.length;i++) {
            int start=0;
            int end = mat.length-1;
            int temp;
            while(start<end) {
                temp = mat[i][start];
                mat[i][start] = mat[i][end];
                mat[i][end] = temp;
                start++;
                end--;
            }
        }
        return true;
        
    }    
}
