package com.pepcode.array;
/*
 Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 Time allowed: O(n)
 Space allowed: O(1)
 Input: Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */
public class MajorityElementinArray {
    public int majorityElemnet(int nums[]){
        Integer me=null;
        int count=0;
        for(int i=0;i<nums.length;i++){
            //naya set of element start hua h for finding(no of same and unequal element  are equal)
            if(count==0){
                me=nums[i];
                count=1;
            }else if(nums[i]==me){
                //set already chal rha h or me nums[i] k barabar mil rhe h to count badhao
                count++;
            }else{
                count--;
            }

        }

        return me;
    }
}
