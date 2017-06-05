package com.company;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by waywee on 2017/5/29.
 */
public class MedianOfTwoArray {
    public static void main(String args[]){
        System.out.println( findMedianSortedArray(new int[]{1},new int[]{4}));
    }

    public static double findMedianSortedArray(int[] nums1, int[] nums2){
        double ans=0;
        boolean isEven = (nums1.length + nums2.length)
                % 2 == 0 ? true : false;

        if(nums1.length == 0)
            return isEven ? ((double) (nums2[nums2.length/2]
                    + nums2[nums2.length/2 - 1]))/2 : nums2[nums2.length/2];

        if(nums2.length == 0)
            return isEven ? ((double) (nums1[nums1.length/2]
                    + nums1[nums1.length/2 - 1]))/2 : nums1[nums1.length/2];

        if(nums1.length + nums2.length == 2)
            return ((double) nums1[0] + nums2[0])/2;



        int[] stack = {0,0,0};
        if(nums1[0] > nums2[0]) {
            stack[2] = nums1[0];
            stack[1] = nums2[0];
        }else {
            stack[2] = nums2[0];
            stack[1] = nums1[0];
        }

        for(int i=0,j=0; i+j < (nums1.length + nums2.length)/2;){
            if(nums1[i] >= nums2[j]
                    && j < nums2.length - 1)
                push(stack, nums2[++j]);
            else if(nums1[i] < nums2[j]
                    && i < nums1.length - 1)
                push(stack, nums1[++i]);
            else if(i == nums1.length - 1)
                push(stack, nums2[++j]);
            else if(j == nums2.length - 1)
                push(stack, nums1[++i]);
        }

        return  isEven ? ((double) (stack[0]+stack[1])/2) : stack[1];
    }

    public static void push(int[] stack, int el){
        if(el >= stack[2]){
            stack[0] = stack[1];
            stack[1] = stack[2];
            stack[2] = el;
        }else{
            stack[0] = stack[1];
            stack[1] = el;
        }
    }
}
