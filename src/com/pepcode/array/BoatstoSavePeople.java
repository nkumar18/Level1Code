package com.pepcode.array;

import java.util.Arrays;

public class BoatstoSavePeople {
    public int numRescueBoats(int[] people, int limit) {
     //sabse phle sort kardenge sabse bhari plus sabse halka ka sum limit se chota hoga ya bada hoga
        Arrays.sort(people);
        int left=0;
        int right=people.length-1;
        int boatcount=0;
        while(left<right){
            if(people[left]+people[right]<=limit){
             boatcount++;
             left++;
             right--;
            }
             else{
                 right--; // right minus minus kardene jise right par k element boatcount m add karlenge or left ko kuch nhi krenge
                 boatcount++;
                }
            }
        if (left==right){
            boatcount+=1;
        }
     return boatcount;
    }

}
