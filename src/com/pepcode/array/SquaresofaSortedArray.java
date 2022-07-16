package com.pepcode.array;

   /*
    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].
     */

public class SquaresofaSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] res= new int[nums.length]; //array to store result of square
        int l=0; //nums left index
        int r=nums.length-1;//nums right index
        int k=res.length-1;//result array index last se bharenge

        while(k>=0){
            if(Math.abs(nums[l])<Math.abs(nums[r])){   //agar left ka element chota h right se to riht ka square karnege or right --
                res[k]= nums[r] * nums[r];
                r--;
            }else{
                //left ka element ka square karenge or left ++
                res[k]=nums[l]*nums[l];
                l++;
            }
            k--;  //k hamesa -- kyunki value last se fill ho rha h
        }

        return res;
    }


    public static void main(String[] args) {

    }
}
