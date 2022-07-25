package com.pepcode.array;
/*
https://leetcode.com/problems/max-chunks-to-make-sorted/
Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
 */
/*
Approach:
we can draw line in between array if max ==index of elemnt in chunks
 */
public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
       if(arr.length==0){
           return 0;
       }
       //Let us consider max = sabse choti value
       int max=Integer.MIN_VALUE;
       int count=0;

       for(int i=0;i<arr.length;i++){
       //jab jab max index k barabr ho counter badha lo
           // find max with arr elemnt
       max=Math.max(arr[i],max);
       if(max==i){
           count++;
       }
       }
        return count;
    }
}
