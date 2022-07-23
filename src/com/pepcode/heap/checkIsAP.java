package com.pepcode.heap;

import java.util.HashSet;

/*
Time Complexity – O(n)
Auxiliary Space – O(n)
Approach:
1.put all val in hashset
2. find min and smin
3.find d and term
4. check in hashset if term is present in set
 */
public class checkIsAP {
    public static void main(String[] args) {
        int[] A = { 20, 15, 5, 0, 10 };
        int n = A.length;
        System.out.println(checkIsAP(A, n));
    }

    private static boolean checkIsAP(int[] arr, int n) {
        //find min and max
        HashSet<Integer> set = new HashSet<Integer>();
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        for (int val : arr) {
            //add all value to set
            set.add(val);
            //val<min<smin
            if (val < min) {
                smin = min;
                min = val;
                //min<val<smin
            } else if(val<smin) {
                smin = val;
            }
        } //n
        int d = smin - min;
        //loop for making term

        for (int i = 1; i <= n; i++) {
            int term = min + (i - 1) * d;
            if (!set.contains(term)) {
                return false;
            }
        } //n
        return true;
    }
}