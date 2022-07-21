package com.pepcode.heap;
/*
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
        int ans=0;
        int sum=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int val : nums){
            sum+=val;
            if(hm.containsKey(sum-k)){
                int x= hm.get(sum-k);
                ans+=x;
            }
            if(hm.containsKey(sum)){
                int x= hm.get(sum);
                hm.put(sum,x+1);
            }else{
                hm.put(sum,1);
            }
        }
        return ans;

    }
}
