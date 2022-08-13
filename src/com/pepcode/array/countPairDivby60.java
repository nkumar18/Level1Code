package com.pepcode.array;
/*
https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/submissions/
 */
public class countPairDivby60 {
    public int numPairsDivisibleBy60(int[] time) {
      //step take array of fqmap till num
        int[] fqmap= new int[60];
        int res=0;
        for(int val:time){
            int remainder=val%60;
            if(remainder==0){
                //0 remainde 0 wale k sath pair bana dega
                res+=fqmap[0];
            }else{
                res+= fqmap[60-remainder];
            }
            fqmap[remainder]++;
        }
        return res;
    }

}


