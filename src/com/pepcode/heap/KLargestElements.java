package com.pepcode.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class KLargestElements {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < arr.length; i++) {
                if (i < k) {
                    pq.add(arr[i]);    //klok
                } else {
                    if (arr[i] > pq.peek()) {
                        pq.remove();    // (n-k)logk
                        pq.add(arr[i]); //(n-k)logk
                    }
                }
            }
            String ans="";
            while (pq.size() > 0) {

               // System.out.println(pq.remove());//klogk  print increasing order
                int valans= pq.remove();
               //print in decreasing order
                ans=valans + " "+ans;
            }
            System.out.println(ans);
        }

    }