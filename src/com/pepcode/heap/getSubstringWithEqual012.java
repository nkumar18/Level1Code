package com.pepcode.heap;

import java.util.HashMap;
/*
 Given a string str of length N which consists of only 0, 1 or 2s, count the number of substring which have equal number of 0s, 1s and 2s.
 Input: str = “0102010”
 Output: 2
 Explanation: Substring str[2, 4] = “102” and
 substring str[4, 6] = “201” has equal number
 of 0, 1 and 2
 */

public class getSubstringWithEqual012 {

public static Long getSubstringWithEqual012(String str){
    long ans=0;
    int c0=0;//count of 0 initially
    int c1=0;//count of 1 initially
    int c2=0;//count of 1 initially
    //1.make a key
    String key="0#0"; //diff of c1-c2=0 and c2-c1=0
    HashMap<String,Integer> hm= new HashMap<>();
    hm.put(key,1); // 1st occurence of key 1
    //Traverse array and update count of 0 1 or 2
    for(int i=0;i<str.length();i++){
        char ch=str.charAt(i);
        if(ch=='0'){
            c0++;
        }else if(ch=='1'){
            c1++;
        }else{
            c2++;
        }
        key=(c1-c0)+"#"+(c2-c1);
        if(hm.containsKey(key)){
            int val=hm.get(key);
            ans+=val; //old frequency ka count update karenge yahi sub array deta h
            hm.put(key,val+1);//map m count 1 badha k add krenege
        }else{
            hm.put(key,1);
        }
    }
    return ans;
}
}
