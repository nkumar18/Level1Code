package com.pepcode.array;
/*
https://leetcode.com/problems/container-with-most-water/

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0; //left pointer index
        int right = height.length - 1; //right pointer index
        while (left < right) {
            int width = right - left;
            int area = Math.min(height[left], height[right]) * width; //minheightofwall * width between two height wall
            maxArea = Math.max(maxArea, area); //max area will be max of 0,max.

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {

    }
}
