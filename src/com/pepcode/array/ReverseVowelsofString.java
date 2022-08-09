package com.pepcode.array;
/*
Ex- Leetcode
    Leotcede
    Hello ->Holle
 */
public class ReverseVowelsofString {
    public String reverseVowels(String s) {
      //create Stringbuilder as it will be a modified string.
        StringBuilder sb=new StringBuilder(s);
        //two pointer one at left and other at right
        int li=0;
        int ri=sb.length()-1;
        String checkvowel="aeioueAEIOUE";
        while(li<ri){
            //sb.charAt(li) will give char so find its index
            //checkvowel.indexOf(char) will return -1 if no char is found inside checkvowel
            while(li<ri && checkvowel.indexOf(sb.charAt(li))==-1){
                li++;
            }
            //traverse from rigt to left
            while(li<ri && checkvowel.indexOf(sb.charAt(ri))==-1){
                ri--;
            }
            //if it is not -1 means vowel found then swap li to ri
            char temp=sb.charAt(li);
            sb.setCharAt(li,sb.charAt(ri));
            sb.setCharAt(ri,temp);

            li++;
            ri--;
        }

    return sb.toString();
    }
}
