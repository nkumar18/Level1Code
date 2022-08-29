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
      //kya apke pas dp[n] store h to return karo
      if(dp[n]!=0){
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
    public static void main(String[] args) {
        displayFibo();


    }
}
