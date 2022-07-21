package com.pepcode.heap;

import java.util.HashMap;

/*
1 set should have same value
each set length should be of size X
This is only possible if frequency of all such number = gcd of freq of these number
 */
public class XOfAKindInADeckOfCards {

    public boolean hasGroupsSizeX(int[] deck){
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int val:deck){
            int freq= map.getOrDefault(val,0);
            map.put(val,freq+1);
        }
        int counter=0;
        int gcd=1;

        for(int key:map.keySet()){
         if(counter==0){
             gcd=map.get(key);
         }else{
             int numb=map.get(key);
            gcd= getGCD(numb,gcd);
         }
         counter++;
        }
        return gcd>=2;
    }
    //get gcd of two number
    public int getGCD(int n1,int n2){
        while(n1%n2 !=0){
          int rem= n1%n2;
          n1=n2;
          n2=rem;
        }
        return n2;
    }
}
