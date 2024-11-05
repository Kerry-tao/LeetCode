package org.taoyi;

public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int answer[] = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            answer[i] = 0;
            int tmp = i+1;
            if(i>0&&temperatures[i]>=temperatures[i-1]){
                tmp = answer[i-1]+i-1;
            }
            for(int j=tmp;j<temperatures.length;j++){
                if(temperatures[j]>temperatures[i]){
                    answer[i] = j-i;
                    break;
                }
            }
        }
        return answer;
    }
}
