package com.pepcode.dp;

import java.util.Arrays;

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
    /*
    https://leetcode.com/problems/climbing-stairs/submissions/
    Solution 1 starts======
     */
    public int climbStairs(int n) {
        int[] dp= new int[n+1];

        dp[0]=1;
        dp[1]=1;
        for(int i=2; i<= n; i++){

            dp[i] = dp[i-1] + dp[i-2];

        }
        return dp[n];

    }
    //Solution 2 starts======
    public int climbStairs_rec(int n) {
        int a=1,b=1;
        for(int i=2; i<= n; i++){

            int sum= a+b;
                a=b;
                b=sum;

        }
        return b;

    }
    /*
    Min Cost Climbing Stairs Leetcode 746
     */
    public int minCostClimbingStairs(int[] cost) {
        int N=cost.length;
        int[] dp= new int[N];//0 to 9
        for(int n=0;n<N;n++){
            if(n<=1){
                //0 and 1 index
                dp[n]=cost[n];
                continue;
            }

            int ans= Math.min(dp[n-1],dp[n-2]) + cost[n];
            dp[n]=ans;
        }
       return Math.min(dp[N-1],dp[N-2]);
    }
    //Leetcode 91 numdecoding 1
    public int numDecodings(String s) {
        int[] dp= new int[s.length()+1];
        Arrays.fill(dp,-1);
        int ans=numDecodings(s,0,dp);
        return ans;
    }
    public int numDecodings(String s,int idx,int dp[]) {
        //base case at dp[array.length]=1
        if (idx == s.length()) {
            return dp[idx] = 1;
        }
        if (dp[idx] != -1)
            return dp[idx];
        //for ch1 single coming 1 to 9
        char ch1 = s.charAt(idx);
        if (ch1 == '0') {
            return 0;
        }
        int count = 0;
        count += numDecodings(s, idx + 1, dp);
        //for ch2  coming with pair 10 to 26

        if (idx < s.length() - 1) {
            char ch2 = s.charAt(idx + 1);
            //calculate  num ex-'23'= (2-'0')*10 +('3'-0)
            int num = (ch1 - '0') * 10 + (ch2 - '0');
            if (num <= 26) {
                count += numDecodings(s, idx + 2, dp);
            }
        }
        return dp[idx]=count;
    }
    //Leetcode 631
    public int numDecodings_2(String s) {
        long[] dp = new long[s.length() + 1];
        Arrays.fill(dp, -1);
        long ans = numDecodings_memo(s, 0, dp);
        return (int) ans;
    }

    long numDecodings_memo(String s, int idx, long[] dp) {
        long mod = (int) 1e9 + 7;
        int n=s.length();
        if (idx == n) {
            return dp[idx] = 1;
        }

        if (dp[idx] != -1)
            return dp[idx];

        char ch= s.charAt(idx);

        if (ch== '0') {
            return dp[idx]=0;
        }

        long count = 0;
        if (ch == '*') {
            count = (count + 9 * numDecodings_memo(s, idx + 1, dp)) % mod;
            if (idx < n- 1) {
                char ch1 = s.charAt(idx + 1);
                if(ch1>='0' && ch1<='6')
                    count=(count+ 2*numDecodings_memo(s, idx + 2, dp)) % mod;
                else if(ch1>='7' && ch1<='9')
                    count=(count+ 1*numDecodings_memo(s, idx + 2, dp)) % mod;
                else{
                    count=(count+ 15*numDecodings_memo(s, idx + 2, dp)) % mod;
                }

            }
        } else {
            count+= 1*numDecodings_memo(s, idx + 1, dp) % mod;
            if(idx< n-1){
                char ch1 = s.charAt(idx + 1);
                if(ch1=='*' && ch=='1')
                    count=(count+ 9*numDecodings_memo(s, idx + 2, dp)) % mod;
                else if(ch1=='*' && ch=='2')
                    count=(count+ 6*numDecodings_memo(s, idx + 2, dp)) % mod;
                else if (ch1!='*'){
                    int num=(ch-'0')*10 +(ch1-'0');
                    if(num<= 26)
                        count=(count+ 1*numDecodings_memo(s, idx + 2, dp))%mod;
                }
            }
        }

        return dp[idx] = count;
    }
    //Path with Maximum Gold allowed 3 dir right , right up, right down
    public static int getMaximumGold(int [][] arr) {


        int m=arr.length;int n=arr[0].length;
        int[][] dp= new int[m][n];
        int [][] dir={{0,1},{1,1},{-1,1}};
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        int maxGold=0;
        for(int r=0;r<m;r++){
            maxGold=Math.max(maxGold,goldmine(arr,r,0,dp,dir));
        }
        System.out.println(maxGold);
        return maxGold;

    }
    private static int goldmine(int [][] arr,int sr,int sc,int[][]dp,int[][] dir) {
        int maxGold = 0;
        int m = arr.length;
        int n = arr[0].length;
        //last column
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
    }
    //Count number of ways to partition a set into k subsets
    //https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/?ref=lbp

    public static int DivideNinKGroup(int n,int k,int[][]dp){
        if(n==k ||k==1){
            return dp[n][k]=1;
        }
        if(dp[n][k]!=0){
            return dp[n][k];
        }
        int selfgroup=DivideNinKGroup(n-1,k-1,dp);
        int partofFroup=DivideNinKGroup(n-1,k,dp)*k;
        int ans=selfgroup+partofFroup;
        return dp[n][k]=ans;
    }
    public static void dividentokgroup(){
        int n=5;
        int k=3;
        int[][] dp= new int[n+1][k+1];
        System.out.print(DivideNinKGroup(n,k,dp));
    }

    public static void main(String[] args) {
      //  displayFibo();
        int[][] arr={{10, 33, 13, 15}, {22, 21, 04, 1}, {5, 0, 2, 3}, {0, 6, 14, 2}};
      //  getMaximumGold(arr);
        dividentokgroup();
    }
}
