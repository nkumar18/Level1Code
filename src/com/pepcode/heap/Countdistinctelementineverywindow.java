package com.pepcode.heap;

import java.util.ArrayList;
import java.util.HashMap;

public class Countdistinctelementineverywindow {
    ArrayList<Integer> countDistinct(int A[], int n, int k){
      HashMap<Integer,Integer> map= new HashMap<>();
      ArrayList<Integer> list= new ArrayList<>();
      //Acquire wale element k-1 tak and unki freq
      for(int i=0;i<=k-2;i++){
          map.put(A[i],map.getOrDefault(A[i],0)+1);
      }
      //Acquire,add to list and release
      for(int j=0,i= k-1;i< A.length;){
          map.put(A[i],map.getOrDefault(A[i],0)+1);//acquire
          list.add(map.size());//add to list
          //release
          int freqj=map.get(A[j]);
          if(freqj==1){
              map.remove(A[j]);
          }else{
              map.put(A[j],freqj-1);
          }
          i++;
          j++;
        }
     return list;
    }
}
