package com.pepcode.array;
/*
https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/submissions/
  Algo: int e=-1 and s=-1
  if nums is between [L,R], then e=i and res+=e-s
         if >R then S=E and res+=e-s
         if <L then donot do anything and res+=e-s
 */
public class NumberofSubarraywithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
     int s=-1; //start index
     int e=-1; //end index
      int res=0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]>=left && nums[i]<=right){
                e=i;
            }else if(nums[i]>right){
                e=s=i;
            }else{
                //donothing
            }
            res+=e-s;

        }
        return res;
    }

}
