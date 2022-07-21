package com.pepcode.heap;

import java.util.HashMap;

/*Approch
 //remainder ko iterate karo K-1 tak and count for below
        // 1. if both element of pair is of 0 remainder count= 2c2 =2*(2-1)/2
        // 2. else if both element of pair is having equal remainder
        // so it will be same remainer for mid K/2 eg: out of 0,1,2,3,4,5 Let say 3 is pair with 3
        // count= 2c2 =2*(2-1)/2
        // 3. if pair element is divisible by K and there exist K-i for them
        //   eg: (pK+r) AND QK+(K-r) so they will make pair
 */
public class CountPairsinArraysdivisiblebyk {
    public static long countKdivPairs(int arr[], int n, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        //find remainder and their frequency for all items in array
        for(int val:arr){
            int rem=val%k;
            int freq=map.getOrDefault(rem,0);
            map.put(rem,freq+1);
        }
        long ans=0; //for gfg
        //why K/2? because all remainder find their pair till k/2
        for(int i=0;i<=k/2;i++){
            if(i==0){
                int freq=map.getOrDefault(i,0);
                ans+=(freq*(freq-1))/2;
            }else if(2*i==k){
                int freq=map.getOrDefault(i,0);
                ans+=(freq*(freq-1))/2;
            }else{
                int freqofith=map.getOrDefault(i,0);
                int freqDiffKI=map.getOrDefault(k-i,0);
                ans+=(freqofith*freqDiffKI);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int A[] = { 2, 2, 1, 7, 5, 3 };
        int n = 6;
        int K = 4;
        System.out.print(countKdivPairs(A, n, K));
    }
}
