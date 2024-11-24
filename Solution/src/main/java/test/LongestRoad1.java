package test;
import java.util.Stack;

public class LongestRoad1 {
    private static int maxPathSum = 0;
    private static Stack<TreeNode> path = new Stack<TreeNode>();
    private static TreeNode start;
    private static TreeNode end;

    static class  TreeNode {
        int val;
        int longValue;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(){}
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
        System.out.println(root.val+" "+root.longValue);
        printTree(root.left);
        printTree(root.right);
    }

    public static int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPath(root.left);
        int right = maxPath(root.right);
        int flag = 1;
        if(left<0&&right<0){
            flag = 0;
        }
        root.longValue = Math.max(Math.max(left, right) + root.val, root.val);
        if(root.longValue>maxPathSum){
            if(!path.isEmpty()){
                TreeNode node = path.peek();
                if(node==root.left||node==root.right){
                    path.add(root);
                }else{
                    path.clear();
                }
                }
                if(flag==1){
                    path.add(root);
                }else{
                    path.clear();
                    path.add(root);
                }
            maxPathSum = root.longValue;

            }
        return root.longValue;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 3, -4, 5, 6, 7, 8, 9, 10};
        // 构建一棵树
        TreeNode root = BuildTree(nums, 0 );
        // 递归找出当前节点为根节点的最长路径
        start = root;
        end = root;
        System.out.println(maxPath(root));
        printTree(root);
        System.out.println(maxPathSum);
//        System.out.println(path);
        // 找出全局最大的路径
        // 打印路径
        while (!path.isEmpty()){
            System.out.println(path.pop().val);
        }
//        System.out.println(maxFinal(root));
    }
}