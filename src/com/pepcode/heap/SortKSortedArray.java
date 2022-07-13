package com.pepcode.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SortKSortedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int k=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        //add up to k+1 elements in funnel
        for(int i=0;i<k+1;i++){
            pq.add(arr[i]);
        }
        //release and add after k+1
        for(int i=k+1;i<arr.length;i++){
            pq.remove();
            pq.add(arr[i]);
        }

        while(pq.size()>0){
            System.out.println(pq.remove());
        }
    }
}
