package com.pepcode.dp;

public class dpset {
    //display
    public static void  display(int [] dp){
      for(int ele:dp){
          System.out.print(ele+ " ");
      }
      System.out.println();
    }
    public static void  display2d(int [][] dp){
        for(int[] ele:dp) {
            display(ele);
        }
        System.out.println();
    }
  public static int  fib_memo(int[] dp, int n){
      if(n<=1){
          return dp[n]=n;
      }
      //kya apke pas dp[n] store h to return karo jaha p -1 nahi ayega matlab waha par ka ans evaluated h
      if(dp[n]!=-1){
        return dp[n];
      }
      int ans=fib_memo(dp,n-1)+ fib_memo(dp,n-2);
      return dp[n]=ans;//ans ko store karlo dp[n] m
    }
    public static int  fib_tab(int[] dp, int N){
        for(int n=0;n<=N;n++) {
            if (n <= 1) {
                dp[n] = n;
                continue;
            }
            int ans = dp[n - 1] + dp[n - 2];//fib_memo(dp,n-1)+ fib_memo(dp,n-2);
            dp[n]=ans;
        }
        return dp[N];//ans ko store karlo dp[n] m
    }
    public static void displayFibo(){
      int n=10;
      int[] dp= new int[n+1];
     // System.out.println(fib_memo(dp,n));
      //  System.out.println(fib_tab(dp,n));
        System.out.println(fib_optimisation(n)) ;
     // display(dp); //observation karo
    }
     public static int fib_optimisation(int N){
        int a=0 ;int b=1;
        for(int i=2;i<=N;i++){
            int sum=a+b;
            a= b;
            b= sum;
        }
        return b;
     }
     /*
        https://leetcode.com/problems/unique-paths/  Problem 62
      */
    //start=============
     public static int mazepath_tab(int SR, int SC,int ER, int EC, int[][] dp,int[][] dir){
         for(int sr=ER; sr>=SR; sr--){
             for(int sc=EC;sc>=SC;sc--){
                 if(ER==sr && EC==sc){
                     dp[sr][sc]=1;
                     continue;
                 }

                 int count=0;
                 for(int[] d:dir){
                     int r= sr+d[0], c=sc+d[1];;

                     if(r>=0 && c>=0 && r<dp.length && c<dp[0].length){
                         count+=dp[r][c];

                     }
                 }
                 dp[sr][sc] = count;
             }
         }
         return dp[SR][SC];
     }

    public int uniquePaths(int n, int m) {
        int [][]dp= new int[n][m];
        int [][]dir={{1,0},{0,1}};

        return mazepath_tab(0,0,n-1,m-1,dp,dir);

    }
    //=============End============
    public static int mazepathJump_tab(int SR, int SC,int ER, int EC, int [][]dp,int[][]dir){
        for(int sr=ER;sr>=SR;sr--){
            for(int sc=EC;sc>=SC;sc--){
                if(ER==sr && EC==sc){
                    dp[sr][sc]=1;
                    continue;
                }

                int count=1;
                for(int[]d:dir){
                    int r=sr+d[0];
                    int c=sc+d[1];
                    while(r>=0 && c>=0 && r<dp.length && c<dp[0].length){
                        count+=dp[r][c];
                        r+=d[0];
                        c+=d[1];
                    }
                }
                dp[sr][sc]=count;
            }
        }
        return dp[SR][SC];
    }
    /*Leetcode unique path with obstacle grid 63
    //https://leetcode.com/problems/unique-paths-ii/submissions/
    */
    //start=========================
    public static int mazepath_tab(int SR, int SC,int ER, int EC, int[][] dp,int[][] dir,int[][] obstacleGrid){
        for(int sr=ER; sr>=SR; sr--){
            for(int sc=EC;sc>=SC;sc--){
                if(ER==sr && EC==sc){
                    dp[sr][sc]=1;
                    continue;
                }

                int count=0;
                for(int[] d:dir){
                    int r= sr+d[0], c=sc+d[1];;

                    if(r>=0 && c>=0 && r<dp.length && c<dp[0].length && obstacleGrid[r][c]==0){
                        count+=dp[r][c];

                    }
                }
                dp[sr][sc] = count;
            }
        }
        return dp[SR][SC];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1 || obstacleGrid[n-1][m-1]==1){
            return 0;
        }
        int [][]dp= new int[n][m];
        int [][]dir={{1,0},{0,1}};

        return mazepath_tab(0,0,n-1,m-1,dp,dir,obstacleGrid);
    }
    //End=========================
    public static void main(String[] args) {
        displayFibo();


    }
}
