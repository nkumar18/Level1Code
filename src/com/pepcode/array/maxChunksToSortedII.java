package com.pepcode.array;
/*
https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
Approach
1. max elemnt of a chunk on left is less than min elemnt of right then a line can be drawn in between

maxfromleft  4 5 5  5  9 9 9 9  10
ex-          4,5,2 ,3|,9,8,6,7,|10
minfromright 2 2 2  3   6 6 6 7  10

 */

public class maxChunksToSortedII {
    public int maxChunksToSorted(int[] arr) {
        //array to store min from right
        int[] minfr= new int[arr.length];
        //last se min calculate kiya
        //last k bad wala element m last eleemnt sabse chota hoga
        //minfr[arr.length-1]//last element will be min and equal to last elemet
        minfr[arr.length-1]=arr[arr.length-1];

        //right se left index ki taraf chal rha hu
        for(int i=arr.length-2; i>=0;i--){
            //mir from right compare honge current elemnt at index i
            minfr[i]=Math.min(arr[i],minfr[i+1]);
            //yaha current elemnt =arr[i];
            //sabse chota elemnt current elemnt k bad wale = minfr[i+1]
        }
        int count=0;
        int max=Integer.MIN_VALUE;
        //loop for maxfrom left
        for(int i=0;i<arr.length-1;i++){
            max=Math.max(arr[i], max);
            if(max<=minfr[i+1]){
                count++;
            }
        }

     return count+1;//chunk/group=no. of line +1;
    }
}
