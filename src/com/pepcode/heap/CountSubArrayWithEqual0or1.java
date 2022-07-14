package com.pepcode.heap;
import java.util.*;
public class CountSubArrayWithEqual0or1 {

    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//mtlb 0 phle 1 bar aachuka hai

        int sum = 0;
        for (int val : arr) {
            if (val == 0) {
                sum += -1;
            } else if (val == 1) {
                sum += 1;
            }
            //sum ki frequency phle kitni bar aa gayi wo h x use ans m update karo
            if (map.containsKey(sum)) {
                int x = map.get(sum);
                ans += x;
                map.put(sum, x + 1);
            } else {
                map.put(sum, 1);
            }

        }
        return ans;
    }
    public static void main(String[] args) {

    }

    }

