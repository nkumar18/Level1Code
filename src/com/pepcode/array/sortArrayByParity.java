package com.pepcode.array;

public class sortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        //Assume that i travese each number  and j collects all even number
        //let us both are at same index
        int i = 0;
        int j = 0;

        while (i < nums.length) {
            //if i faces odd number simply increase index and if faces even then swap elemnt and increase both index
            if (nums[i] % 2 == 1) {
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
                j++;
            }
        }

        return nums;
    }
}