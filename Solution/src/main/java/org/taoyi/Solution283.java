package org.taoyi;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if(len ==0) return;

        int i = 0;
        while(i<len&&nums[i]==0){
            i++;
        }
        if(i>=len) return;

        if(i!=0){
            nums[0] = nums[i];
            nums[i] = 0;
        }

        int j = i+1;
        i = 0;
        //遍历数组
        while(j<len){
            if(nums[j]!=0){
                i++;
                if(i!=j){
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
            j++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new Solution283().moveZeroes(nums);
        for(int i:nums){
            System.out.println(i);
        }
    }
}
