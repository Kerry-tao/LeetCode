package test;

import java.util.Stack;

public class LongestRoad {
    private static Stack<Integer> stack = new Stack<>();
    private static int maxNum = 0;
    static class  TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(){}
        int longest = 0;
        Stack<Integer> road = new Stack<>();
    }

    public static TreeNode BuildTree(int[] nums, int index) {
        if (index >= nums.length) {
            return null;
        }
        TreeNode node = new TreeNode(nums[index]);
        node.left = BuildTree(nums, 2 * index + 1);
        node.right = BuildTree(nums, 2 * index + 2);
        return node;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val+" "+root.longest+" "+root.road);
        printTree(root.left);
        printTree(root.right);
    }

    // 当前节点开始的最长路径
    public static int printCurrentMax(TreeNode root){
        if(root==null)
            return 0;
        int left = printCurrentMax(root.left);
        int right = printCurrentMax(root.right);

        int max = Math.max(left, right) + root.val;

        if(root.left!=null||root.right!=null){
            root.road.clear();
            root.road.add(root.val);
            root.road.addAll(left>right?root.left.road:root.right.road);
        }else{
            root.road.add(root.val);
        }
        root.longest = max;
        return max;
    }

    public static void maxFinal(TreeNode root) {
        if(root==null) return;
        if(root.longest > maxNum){
            maxNum = root.longest;
            stack.clear();
            stack.addAll(root.road);
        }
        if(root.left!=null) maxFinal(root.left);
        if(root.right!=null) maxFinal(root.right);
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, -3, -4, -5, 6, 7, 8, 9, 10};
        TreeNode root = BuildTree(nums, 0 );
        printCurrentMax(root);
        maxFinal(root);
        System.out.println(maxNum);
        printTree(root);
    }
}
