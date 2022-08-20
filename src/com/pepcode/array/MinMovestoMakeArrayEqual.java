package com.pepcode.array;
/*
https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
Input: nums = [1,2,3]
Output: 3
Explanation: Only three moves are needed (remember each move increments two elements):
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class MinMovestoMakeArrayEqual {
    public int minMoves(int[] nums) {
     //inorder to make each element equal in array find min element in array and subtract each elemnt with min till it becomes equal
     int min=Integer.MAX_VALUE;
     int minmoves=0;
     for(int val:nums){
         min=Math.min(min,val);
     }
     for(int val : nums){
         minmoves+=val-min;
     }
     return minmoves;
    }
}
