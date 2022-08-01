package com.pepcode.array;
/*
You are given an integer array nums where the largest integer is unique.
Determine whether the largest element in the array is at least twice as much as every other number in the array.
 If it is, return the index of the largest element, or return -1 otherwise.

 Ex-Input: nums = [3,6,1,0]
Output: 1
Explanation: 6 is the largest integer.
For every other number in the array x, 6 is at least twice as big as x.
The index of value 6 is 1, so we return 1.
 */
public class LargestNumberAtLeastTwiceofOthers {
    public int dominantIndex(int[] nums) {
      int length= nums.length,maxindex=0,max=nums[0];
      for(int i=0;i<length;i++){
          if(nums[i]>max){
              max=nums[i];
              maxindex=i;
          }
      }
      //nums*2 bada h max se par maxindex!=i
      for(int i=0; i<length;i++){
          if(i!=maxindex && (nums[i]*2)>max){
              return -1;
          }
      }
      return maxindex;
    }
}
