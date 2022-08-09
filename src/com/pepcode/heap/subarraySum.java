package com.pepcode.heap;

import java.util.ArrayList;


/*
https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1?page=1&company[]=Visa&curated[]=1&sortBy=submissions
 */
public class subarraySum {
   /* {
        ArrayList<Integer> mylist= new ArrayList<>();
        int curr_S=0;
        int start=0;
        int end=-1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            curr_S = curr_S + arr[i];
            if(curr_S-s==0){
                start=0;
                end=i;
                break;
            }
            if(map.containsKey(curr_S-s)){
                start= map.get(curr_S-s) +1;
                end=i;
                break;
            }
            //if value is not present
            map.put(curr_S,i);

        }
        mylist.add(start);
        mylist.add(end);
      return mylist;
    }*/
   static ArrayList<Integer> subarraySum1(int[] arr, int n, int s){
       ArrayList<Integer> ans =new ArrayList();
       if(s==0){
           ans.add(-1);
           return ans;
       }
       int sum=0;
       int j=0;
       for(int i=0;i<n;i++){
           j=i;
           while(sum<s && j<n){
               sum+=arr[j];
               j++;
           }
           if(sum==s) {
               // System.out.println(i+"  "+j);
               ans.add(i+1);
               ans.add(j);
               return ans;
               //break;
           }
           else{
               sum=0;
           }
       }
       ans.add(-1);
       return ans;
   }
}



