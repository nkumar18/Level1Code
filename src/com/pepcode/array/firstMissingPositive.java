package com.pepcode.array;

public class firstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;//// 1,2,3...n (n+1) => Smallest missing will be among these only
        //step1: if num lies out of range of its index 1 to length then put length+1; for identification not in use
        for(int i=0;i<n;i++){
            if(nums[i]<=0||nums[i]>n){
                nums[i]=n+1;
            }
        }

        //steps 2: make all value absolute for negative num
        for(int i=0;i<nums.length;i++){
            int val=Math.abs(nums[i]);
            if(val<=n){
                //if val is in range of its lenth of array make this negative
                //find idx
                int index= val-1;
                if(nums[index]>0){
                    //make negative
                    nums[index]=-1*nums[index];

                }
            }
        }

        //step3 find position where number is positive because all valid number is filled negative in array
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                return i+1;//this index num which is first time +ve
            }
        }
        //step4: Agar aisa kuch bhi nhi hua  then
        //n+1 => when array will contain 1 to n all numbers
         return n+1; //1 to length k under koi nhi mila to smallest ni+1 hoga

    }
}
