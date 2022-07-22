package com.pepcode.heap;

import java.util.HashMap;
/*
Input: answers = [1,1,2]
Output: 5
Explanation:
The two rabbits that answered "1" could both be the same color, say red.
The rabbit that answered "2" can't be red or the answers would be inconsistent.
Say the rabbit that answered "2" was blue.
Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.
https://leetcode.com/problems/rabbits-in-forest/
 */
public class RabbitInForest {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map= new HashMap<>();
        //fqmap
        for(int val :answers){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        int Sum=0;
        //find keyset and their groupsize
        for(int key:map.keySet()){
            int groupSize=key+1;
            int reportess=map.get(key);
            int ng=(int) Math.ceil(reportess*1.0/groupSize*1.0);
            Sum+=ng*groupSize;
        }
        return Sum;
    }

}
