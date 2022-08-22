package com.pepcode.array;

import java.util.Arrays;
/*
https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1
 */
public class FindPairGivenDifference {
    public boolean findPair(int arr[], int size, int n)
    {
        Arrays.sort(arr);
        int j=0;
        int i=1;
        //travere i
        while(i< arr.length){
            if(arr[i]-arr[j]>n){
                //gap bada h kam karo means j ko age bdhao
                j++;

                if(j==i){
                    i++;
                }
            }else if(arr[i]-arr[j]<n){
                i++;
            }else{
                return true;
            }
        }
        return false;

    }
}
