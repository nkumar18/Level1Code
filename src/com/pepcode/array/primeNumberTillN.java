package com.pepcode.array;

import java.util.Arrays;

/*
n tak k prime number btao
 */
public class primeNumberTillN {
    public int countPrimes(int n) {
        if(n < 2){
            return 0;
        }
        //create array of n size
        boolean[] prime= new boolean[n+1];
        Arrays.fill(prime,true);
        prime[0]=false; //skip 0
        prime[1]=false; //skip 1
        for(int div=2;div*div<=n;div++){
            if(prime[div]== false){
                continue;  //agar div se kat gye h to agge number dekho
            }
            //fp variable find prime fp*div bhi kat jayenge
            for(int fp=div;fp*div<=n;fp++){
                prime[fp *div]=false;
            }
        }
        int count=0;
        for(int i=0;i<prime.length-1;i++){
            if(prime[i]==true){
                count++;
            }
        }
        return count;
    }
}
