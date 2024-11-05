package org.taoyi;

public class Solution189 {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k%length;
        int tmp[] = new int[length];
        for(int i=0;i<length;i++){
            int index = i - k;
            if(index<0){
                index = length+index;
            }
            tmp[i] = nums[index];
        }
        for(int i=0;i<length;i++){
            nums[i] = tmp[i];
        }
    }
    public static void main(String[] args)
    {
        int[] nums = {-1,-100,3,99};
        new Solution189().rotate(nums,2);
        for(int i:nums){
            System.out.println(i);
        }
    }
}
