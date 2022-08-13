package com.pepcode.array;
/*
Time complexity mn (log(min(m,n))
diagonal ki length m or n m jo chota hota h
 */
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        //Approch: Take a HashMap of gap between index of row and column
        HashMap<Integer, PriorityQueue<Integer>> map= new HashMap<>();
        int m=mat.length;//row
        int n=mat[0].length;//column

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int gap =i-j;
                if(map.containsKey(gap)==false){
                    //empty pq
                    map.put(gap,new PriorityQueue<>());
                }   //priorityqueue m value dalte jao gap k samne
                    map.get(gap).add(mat[i][j]);

            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int gap =i-j;
               mat[i][j]=map.get(gap).remove();
            }
        }
     return mat;
    }
}
