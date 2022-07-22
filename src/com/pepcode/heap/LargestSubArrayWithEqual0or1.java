package com.pepcode.heap;

import java.util.HashMap;

public class LargestSubArrayWithEqual0or1 {
    public static int maxLen(int[] arr, int N){
        int sum=0;
        int maxsubarraylength=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        //we are storing sum as key and their index as value
        //put sum at index -1 initially
        map.put(0,-1);
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                sum+=-1;
            }else if(arr[i]==1){
                sum+=1;
            }

            if(map.containsKey(sum)){
                int idx=map.get(sum);//old idxx jab sum aya tha
                int length=i-idx; //length = new idx-old idx
                if(length>maxsubarraylength){
                    maxsubarraylength=length;
                }
            }else{
                map.put(sum,i);
            }
        }
        return maxsubarraylength;
    }
    public static void main(String[] args) {

    }
}
