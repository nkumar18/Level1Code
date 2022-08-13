package com.pepcode.array;
/*
https://leetcode.com/problems/maximum-swap/
Ex-        arr=     9 5  3 8 4 6 7 2
        arr index   0 1  2 3 4 5 6 7
right max index     3 3  3 6 6 6 7 -1
 */
public class maximumSwap {
    public int maximumSwap(int num) {
        char[] arr = (num + "").toCharArray();
        //Make an array which stores index of its max from all rightmost number coming after this. from right to left

        int right[] = new int[arr.length];
        //right to left traversing
        for (int i = arr.length - 1; i >= 0; i--) {
            //if element is at last index store index as -1 or infinity as its max value index
            if (i == arr.length - 1) {
                right[i] = -1;
                //2nd last position
            } else if (i == arr.length - 2) {
                right[i] = arr.length - 1;//abhi tak ka max ka index last index hi hoga
            } else {
                //3rd last se ...0 tak
                //EX- Agar 4 6 7 2  m  4  ki bat kre ki kaun right max index hogi
                // 4 is at i , so compare number i+1 ki value ie arr[i+1] ie 6 with its right index  6 p padi value se arr[right[i+1] ie 7 se
                if (arr[i + 1] > arr[right[i + 1]]) {
                    right[i] = i + 1;
                } else {
                    right[i] = right[i + 1];
                }
            }
        }
        //loop ek kam tak chalega kyunki last m -1 tha index
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[right[i]]) {
                //swap karo
                char temp = arr[i];
                arr[i] = arr[right[i]];
                arr[right[i]] = temp;
                break;
            }
        }

        return Integer.parseInt(new String(arr));
    }
}
