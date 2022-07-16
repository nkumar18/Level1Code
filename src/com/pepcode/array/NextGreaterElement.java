package com.pepcode.array;
/*
Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.
input :683486532
output: usinumber m sabse bado m sabse chotta
 */
/*Approach:
  1. find the biggest digit by traverse from right to left (if number equals then also ) so  that smaller number comes ex- 8 after 8  4 comes smaller
  2. Again start from right and find if any number is greter than 4  if it is swap it
  3. Again reverse the numbr after swap ex-486532 => After Swap 586432 => then reverse digit =234685
     final output: 683234685
 */

public class NextGreaterElement {
    public int nextGreaterElement(int n) {
     //convert into character
        char[] arr= (n+"").toCharArray();
        int i=arr.length-1; //last index p pointer rakhenge left ki taraf traverse karenge
        while(i>0){
            if(arr[i-1]>=arr[i]){
                i--;
            }else{
                break;
            }
        }
        //if i index 0 tak kamte kamte koi element mila hi nahi tpo return -1 (eg: number in decreasing numb 98765432
        if(i==0){
           return -1;
        }
        int idx1= i-1;
        int j= arr.length-1;
        while(j>idx1){
        if(arr[j]>arr[idx1]){
            break;
        }else {
            j--;
        }
        }

        swap(arr,idx1,j);
        //reverse from end to i
        int left =i;
        int right=arr.length-1;
        while(left<right){
            swap(arr,left,right);
            left ++;
            right--;
        }
        String res= new String(arr); //arr is char array convert to string
        long val=Long.parseLong(res);
        return (val>Integer.MAX_VALUE?-1 : (int)val);
    }
   //swap function
   private void swap(char[] arr, int i, int j) {
       char temp=arr[i];
       arr[i]=arr[j];
       arr[j]=temp;
   }

}
