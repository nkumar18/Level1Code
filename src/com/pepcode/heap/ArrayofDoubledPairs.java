package com.pepcode.heap;

import java.util.Arrays;
import java.util.HashMap;
/*
Array of double pair
Leetcode
954. Array of Doubled Pairs
 */
public class ArrayofDoubledPairs {
    public static void main(String[] args) {
        int[] A = { 4, -2, 2,-4 };
        System.out.println(canReorderDoubled(A));
    }
    private static boolean canReorderDoubled(int[] arr) {
        HashMap<Integer,Integer> map= new HashMap<>();
        //sort it
        Arrays.sort(arr);
        //freqmap
        for(int val:arr){
            map.put(val,map.getOrDefault(val,0)+1);
        }


        for(int val:arr){
            if(val != 0 && map.containsKey(val) && map.containsKey(2*val)){
              //val key liye jiski freq 1 se jyada h
                if(map.getOrDefault(val,0) > 1){
                  map.put(val, map.getOrDefault(val,0)-1);
              }else{
                  map.remove(val);
              }
                //2 *val key liye jiski freq 1 se jyada h
                if(map.getOrDefault(2*val,0)>1){
                    map.put(2*val,map.getOrDefault(2*val,0)-1);
                }else{
                    map.remove(2*val);
                }
            }
        }
        //map ka size 0 hai to sab pair settle ho gaye ya fir map m 1 hi elemnt bache jo zero the
        if(map.size()==0){
            return true;
        }else if(map.size()==1 && map.containsKey(0)){
            return true;
        }else{
            return false;
        }
    }
}
