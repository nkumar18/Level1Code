package com.pepcode.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/*
https://leetcode.com/problems/car-pooling/
 */
public class carPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        //Make a HashMap of arrival as key and people as value
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> stops = new TreeSet<>();//stops will indicate how many people at particular stop
        //if two stops are same then in treeset consider overall arival plus departure

        for(int[] trip: trips){
            int people = trip[0];
            int from = trip[1];
            int to = trip[2];
            //for arrival
            if(map.containsKey(from) == false){
                map.put(from, +people);
                stops.add(from);
            } else {
                map.put(from, map.get(from) + people);
            }
            //for departuere
            if(map.containsKey(to) == false){
                map.put(to, -people);
                stops.add(to);
            } else {
                map.put(to, map.get(to) - people);
            }
        }


        //people in car pic
        int pic = 0;
        for(int stop: stops){
            int delta = map.get(stop);
            pic += delta;

            if(pic > capacity){
                return false;
            }
        }

        return true;
    }
}
