package org.taoyi;

import java.util.Arrays;

public class Solution55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int i = 0;
        int[] nums2 = new int[len];
        Arrays.fill(nums2, 0);
        nums2[0] = 1;

        for(int j=0;j<len;j++){
            if(nums2[j]==1){
                for(int k = 0;k<=nums[j];k++){
                    if(j+k<len){
                        nums2[j+k] = 1;
                    }
                }
            }
            if(nums2[len-1]==1) break;
        }
        if(nums2[len-1]==1) return true;
        else return false;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        new Solution55().canJump(nums);
    }
}
