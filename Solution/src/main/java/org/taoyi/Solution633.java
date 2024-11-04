package org.taoyi;


public class Solution633 {
    public boolean judgeSquareSum(int c) {
        boolean flag = false;
        for(int i=(int)Math.sqrt(c/2);i>=0;i--){
            int d = c -i*i;
            int b = (int)Math.sqrt(d);
            if(b*b==d){
                flag =true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(new Solution633().judgeSquareSum(2147483600));
    }
}