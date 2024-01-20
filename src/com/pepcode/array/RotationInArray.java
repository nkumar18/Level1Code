package com.pepcode.array;

import java.util.Scanner;
/**
 * Leetcode https://leetcode.com/problems/rotate-array/description/
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class RotationInArray {

    public void rotate(int[] nums, int k) {
        k =k% nums.length;
        if(k<0){
            k=k + nums.length;
        }
        reverseNum(nums,0,nums.length-k-1);
        reverseNum(nums,nums.length-k,nums.length-1);
        reverseNum(nums,0,nums.length-1);
    }

    public void reverseNum(int[] arr, int start, int end){
        while(start<end){
            int temp= arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }

    }
    public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6,7};
        RotationInArray rotationInArray= new RotationInArray();
        rotationInArray.rotate(nums,3);

        for(int ele:nums){
            System.out.print(ele + ",");
        }
    }
}
