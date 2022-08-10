package com.pepcode.array;

import java.util.Arrays;

/*
Input: nums = [1,2,3]
Output: 2
Basically we calculate median becos ths is position where min effort is required to mov
ex- Input: nums = [1,10,2,9]
Output: 16
first sort
1 2 9 10
calculate sum of diff of ri and li
median is 2 so 2-1 + 9-2 + 10-2 = 16 move
 */
public class minMoves2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int li = 0;
        int ri = nums.length - 1;
        int move = 0;
        while(li < ri){
            move += nums[ri] - nums[li];
            li++;
            ri--;
        }

        return move;
    }

}
