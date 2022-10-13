package com.pepcode.array;

public class maxProductofSubArray {
    public int maxProduct(int[] nums) {
        int res= Integer.MIN_VALUE;
        //prefix
        int prod=1;
        for(int i=0;i<nums.length; i++){
            prod=prod*nums[i];
            if(prod>res){
                res=prod;
            }
            if(prod==0){
                prod=1;
            }
        }
        prod=1;
        //suffix
        for(int i=nums.length-1; i>=0; i--){
            prod=prod*nums[i];
            if(prod>res){
                res=prod;
            }
            if(prod==0){
                prod=1;
            }
        }
        return res;
    }
}
