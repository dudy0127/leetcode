package io.github.dudy.v104;

/**

 给定一个二叉树，找出其最大深度。

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 说明: 叶子节点是指没有子节点的节点。

 示例：
 给定二叉树 [3,9,20,null,null,15,7]，

 3
 / \
 9  20
 /  \
 15   7
 返回它的最大深度 3 。

 TODO: 最小深度
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public int maxDepth(TreeNode root) {

        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return left > right?(left + 1): (right + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(30);
        TreeNode l1 = new TreeNode(9);
        root.left = l1;
        TreeNode l2 = new TreeNode(20);
        root.right = l2;
        TreeNode l3 = new TreeNode(15);
        l1.right = l3;
        TreeNode l4 = new TreeNode(7);
        l2.left = l4;

        Solution s = new Solution();
        int i = s.maxDepth(root);
        System.out.println(i);

    }
}