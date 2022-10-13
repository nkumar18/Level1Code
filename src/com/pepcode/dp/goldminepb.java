package com.pepcode.dp;

import java.util.Arrays;

public class goldminepb {
   public static void main(String args[]) {
     int[][] arr = {{10, 33, 13, 15}, {22, 21, 04, 1}, {5, 0, 2, 3}, {0, 6, 14, 2}};

       int m = arr.length;
       int n = arr[0].length;
       int[][] dp = new int[m][n];
       int[][] dir = {{0, 1}, {1, 1}, {-1, 1}};

       for(int[] d : dp){
           Arrays.fill(d,-1);
       }

       int maxGold = 0;
       for (int r = 0; r < m; r++) {
           maxGold = Math.max(maxGold, goldMine_memo( r, 0,arr, dp, dir));
       }
       System.out.println(maxGold);
   }
    /*private static int goldmine(int [][] arr,int sr,int sc,int[][]dp,int[][] dir) {
        int maxGold = 0;
        int m = arr.length;
        int n = arr[0].length;
        if (sc == n-1) {
           return dp[sr][sc] = arr[sr][sc];
        }
        if (dp[sr][sc] != -1) {
            return dp[sr][sc];
        }
        //for dir
        for (int[] d : dir) {
            int r = sr + d[0];
            int c = sc + d[1];

            if (r >= 0 && c >= 0 && r < m && c < n) {
                maxGold = Math.max(maxGold, goldmine(arr, r, c, dp, dir) + arr[sr][sc]);

            }
        }
        return dp[sr][sc] = maxGold;
    }*/
    public static int goldMine_memo(int r, int c, int[][] mat, int[][] dp, int[][] dir) {
        if (c == mat[0].length - 1) {
            return dp[r][c] = mat[r][c];
        }

        if (dp[r][c] != -1)
            return dp[r][c];

        int maxGold = 0;
        for (int d = 0; d < 3; d++) {
            int x = r + dir[d][0];
            int y = c + dir[d][1];
            if (x >= 0 && x < mat.length) {
                maxGold = Math.max(maxGold, goldMine_memo(x, y, mat, dp, dir));
            }
        }

        return dp[r][c] = maxGold + mat[r][c];
    }
}
