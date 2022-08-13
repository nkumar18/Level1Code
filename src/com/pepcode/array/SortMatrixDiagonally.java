package com.pepcode.array;
/*
Time complexity mn (log(min(m,n))
diagonal ki length m or n m jo chota hota h
 */
import java.util.ArrayList;
import java.util.Collections;
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
    public int[][] diagonalSort_2ndApproch(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for(int gap = -(m - 1); gap <= (n - 1); gap++){
            ArrayList<Integer> diag = new ArrayList<>();
            int i = gap < 0? -gap: 0;
            int j = gap < 0? 0: gap;
            while(i < m && j < n){
                diag.add(mat[i][j]);
                i++;
                j++;
            }

            Collections.sort(diag);
            i = gap < 0? -gap: 0;
            j = gap < 0? 0: gap;
            int idx = 0;
            while(i < m && j < n){
                mat[i][j] = diag.get(idx);
                idx++;
                i++;
                j++;
            }
        }

        return mat;
    }
}
