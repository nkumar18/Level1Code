package com.pepcode.array;

import java.util.Arrays;
/*
https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
 */
public class findPlatform {
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);

        int count = 0;
        int max = 0;

        int i = 0;
        int j = 0;
        while(i < arr.length && j < dep.length){
            if(arr[i] <= dep[j]){
                i++;
                count++;
            } else {
                j++;
                count--;
            }

            max = Math.max(count, max);
        }

        return max;

    }
}
