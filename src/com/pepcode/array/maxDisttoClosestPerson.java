package com.pepcode.array;
/*
https://leetcode.com/problems/maximize-distance-to-closest-person/
 */
public class maxDisttoClosestPerson {
    public int maxDistToClosest(int[] seats) {
      //we have to find max close distance with 1
        // 00000 1 000000001 00000

        int j=-1; //trav pointer
        int finalans=0;
        for(int i=0;i< seats.length;i++){
            //basically when we get 1 then we will find dist
            int ans=0;
            if(seats[i]==1){

                if(j<0) {
                    //phli bar 1 aya ho
                    ans = i;
                }else{
                    //bich m continuos 0 aya ho
                    ans=(i-j)/2;
                }
                //j ko i k brabar krenge dono case m
                j=i;
                finalans=Math.max(ans,finalans);

            }
        }
        //last m 0 ho
        int ans=seats.length-1-j;
        finalans=Math.max(ans,finalans);

        return finalans;
    }
}
