package com.pepcode.array;
/*
    Let us there are k consecutive number for to bring sum till n and s is the strating point
    then n=1  k=1 number  S + 0
         n=2  k=2 number  S + 1
         n=3   3rd number  S + 2
         ....   ..
                --
                k--> S+ (K-1)
                     KS +(K-1)K/2 = Total sum n
                     KS= n-(K-1)K/2
                  1.   means right will always positive
                    n-(K-1)K/2 >0
                    n>(K-1)K/2
                  2.S will be starting point if k divides right side completely
         ...
     Ex- 15   k=1  15
              k=2   7+8
              k=3  4+5+6
              k=4  Not possible
              k=5  1+ 2+3+4+5
          n--->K---> S

     */
public class consecutiveNumbersSum {
    public int consecutiveNumbersSum(int n) {
     int res=0;
     int k=1;
     int check=k*(k-1)/2;
     while(n>check){
         if((n-check)%k==0){
             res++;
         }
         k++;
         check=k*(k-1)/2;
     }
     return res;
    }
}
