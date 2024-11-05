package org.taoyi;

import java.util.Stack;

public class Solution121 {
//    public static int maxProfit(int[] prices)
//    {
//        int maxProfit = 0;
//        int maxNum = 0;
//        int len = prices.length;
//        if(len>0) maxNum = -1;
//        for (int i = 0; i < len; i++) {
//            if(maxNum-prices[i]<maxProfit) continue;
//            if(prices[i]==maxNum||maxNum==-1){
//                maxNum = -1;
//                for(int j=i+1;j<len;j++){
//                    maxNum = Math.max(maxNum,prices[j]);
//                }
//            }
//            maxProfit = Math.max(maxProfit,maxNum-prices[i]);
//        }
//        return maxProfit;
//    } 超时

    public static int maxProfit(int[] prices)
    {
        int maxProfit = 0;
        int len = prices.length;
        int buyPrice = 0;
        if(len>0){
            buyPrice = prices[0];
        }
        for (int i = 0; i < len; i++) {
            if(prices[i]>buyPrice){
                maxProfit = Math.max(maxProfit,prices[i]-buyPrice);
            }else{
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
