package com.pepcode.heap;

import java.io.*;
import java.util.*;
/*
Input
4  no of lists
5  no 0f items in list
10 20 30 40 50
7
5 7 9 11 19 55 57
3
1 2 3
2
32 39
Output:
1 2 3 5 7 9 10 11 19 20 30 32 39 40 50 55 57
 */
public class MergeKSortedList {

    static class Pair implements Comparable {
        int data;
        int li;//lists index
        int di; //data index

        public int compareTo(Object o) {
            Pair other = (Pair) o;
            return this.data - other.data;
        }
    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> rv = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        //sabhi list k 1 st elemnt pq m dal do

        for (int li = 0; li < lists.size(); li++) {
            Pair p = new Pair();
            p.li = li;
            p.di = 0;
            p.data = lists.get(li).get(0);//fisrt element
            pq.add(p);
        }
        //pair k pq se nikal k final rv list m dalo
        //jis list ka data index badhega usi list ka elemnt add hoga pq m but check karna padega usme elemnet h bhi ki nahi
        //remove,add, increase corresponding di and then add data to PQ
        while (pq.size() > 0) {
            Pair rp = pq.peek();
            pq.remove();
            //list m add
            rv.add(rp.data);
            rp.di++;
            if (rp.di < lists.get(rp.li).size()) {
                rp.data = lists.get(rp.li).get(rp.di);
                pq.add(rp);
            }

        }
        return rv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for (int val : mlist) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}
