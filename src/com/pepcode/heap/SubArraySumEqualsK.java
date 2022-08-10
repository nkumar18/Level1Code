package com.pepcode.heap;
/*
prefix sum strategy sum-k k0 count karo to k sum mil jayega
Count of subArray in array whose sum equals k
560. Subarray Sum Equals K
https://leetcode.com/problems/subarray-sum-equals-k/
 */
import java.util.HashMap;
public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] arr={2,5,8,7,9};
        int k=2;
       int ans= subarraySum(arr,k);
       System.out.println(ans);
    }
    private static int subarraySum(int[] nums, int k) {
        int count=0;
        int sum=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
         hm.put(0,1);
        for(int val : nums){
            //calcutate sum at each number
            sum+=val;
            if(hm.containsKey(sum-k)){
                int x= hm.get(sum-k);
                count+=x;
            }
            //store sum ki freq in map
            hm.put(sum,hm.getOrDefault(sum,0)+1);
            /*if(hm.containsKey(sum)){
                int x= hm.get(sum);
                hm.put(sum,x+1);
            }else{
                hm.put(sum,1);
            }*/
        }
        return count;

    }
}
