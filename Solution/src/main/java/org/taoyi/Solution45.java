package org.taoyi;

import java.util.Arrays;

public class Solution45 {
    public int jump(int[] nums)
    {
        int len = nums.length;
        int step[] = new int[len];
        Arrays.fill(step,len);
        if(len==0) return 0;
        step[0] = 0;

        for (int i = 0; i < len; i++) {
            for(int j = 1; j <= nums[i]&&(i+j)<len; j++){
                if(i==0) step[i+j] = 1;
                else{
                    step[i+j] = Math.min(step[i+j],step[i]+1);
                }
            }
        }
        return step[len-1];
    }
    public static void main(String[] args)
    {
        System.out.println(new Solution45().jump(new int[]{2,3,0,1,4}));
    }

}
