package org.taoyi;

public class Solution150 {
    public static int evalRPN(String[] tokens) {
        int n = tokens.length;
        int i = 0;
        int a,b;
        int[] nums = new int[n];
        for(String token:tokens){
            switch (token) {
                case "+":
                    a = nums[--i];
                    b = nums[--i];
                    nums[i++] = a + b;
                    break;
                case "-":
                    a = nums[--i];
                    b = nums[--i];
                    nums[i++] = b - a;
                    break;
                case "*":
                    a = nums[--i];
                    b = nums[--i];
                    nums[i++] = a * b;
                    break;
                case "/":
                    a = nums[--i];
                    b = nums[--i];
                    nums[i++] = b / a;
                    break;
                default:
                    nums[i++] = Integer.parseInt(token);
                    break;
            }
        }
        return nums[0];
    }
    public static void main(String[] args)
    {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
}
