package com.pepcode.array;
/*
https://leetcode.com/problems/long-pressed-name/
Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
 */
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int i=0;//for typed typed ki freq jyada honi chahye
        int j=0;//for name

        while(i<typed.length()){
            //agar type ka char name k char k barabr ho to dono ko obdha
            if(j<name.length() &&typed.charAt(i)==name.charAt(j)){
                i++;
                j++;
                //agar type ka char name k char k barabr nahi hai to kya wo apne ek phle char k barabar
                // h to type wala index bdhao

            }else if(i>0 &&typed.charAt(i)==typed.charAt(i-1)){
                i++;
                //kuch bhi nahi to false
            }else{
                return false; //eg: ssaaedd  and saeed
            }
        }
        return j==name.length();
        //type wala pura process ho jayega and
        // name wala bach jayega ex-typed= aalexx and name=alexa
    }
}
