package test;
import java.util.ArrayList;
import java.util.List;

public class Tree {
    // 定义二叉树节点
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }

    static class MaxPathSum {
        // 记录当前最大路径和
        private int maxSum = Integer.MIN_VALUE;
        // 记录最大路径的节点路径
        private List<TreeNode> maxPath = new ArrayList<>();
        // 用于临时存储当前路径
        private List<TreeNode> currentPath = new ArrayList<>();

        // 主函数，返回最大路径和的路径
        public List<TreeNode> maxPath(TreeNode root) {
            findMaxSum(root);
            return maxPath;
        }

        // 递归计算每个节点的最大路径和
        private int findMaxSum(TreeNode node) {
            if (node == null) {
                return 0;
            }

            // 递归计算左子树最大路径和，如果路径和为负则不考虑
            int leftSum = Math.max(0, findMaxSum(node.left));  // 左子树路径和
            int rightSum = Math.max(0, findMaxSum(node.right)); // 右子树路径和

            // 当前节点的最大路径和
            int currentSum = node.val  + Math.max(leftSum, rightSum);

            // 如果当前路径和大于已记录的最大路径和，则更新最大路径和和路径
            if (currentSum > maxSum) {
                maxSum = currentSum;
                // 清空当前路径并重新计算路径
                maxPath.clear();
                currentPath.clear();
                // 重新构建最大路径
                buildPath(node, leftSum > rightSum);
            }

            // 返回当前节点的最大路径和（只能选择一个子树的路径）
            return node.val + Math.max(leftSum, rightSum);
        }

        // 根据当前节点和子树路径选择来构建路径
        private void buildPath(TreeNode node, boolean leftIsLarger) {
            currentPath.add(node);  // 将当前节点加入路径

            // 根据左子树和右子树的路径来决定构建哪一条路径
            if (leftIsLarger && node.left != null) {
                buildPath(node.left, node.left.left != null);
            } else if (node.right != null) {
                buildPath(node.right, node.right.left != null);
            }

            // 更新最大路径
            maxPath = new ArrayList<>(currentPath);
        }

        public static void main(String[] args) {
            // 构造一个二叉树
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(-5);
            root.left.right = new TreeNode(4);
            root.right.left = new TreeNode(-6);
            root.right.right = new TreeNode(7);

            MaxPathSum solution = new MaxPathSum();
            List<TreeNode> resultPath = solution.maxPath(root);

            // 输出路径节点值
            System.out.print("最大路径和的路径为：");
            for (TreeNode node : resultPath) {
                System.out.print(node.val + " ");
            }
        }
    }
}
