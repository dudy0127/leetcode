package io.github.dudy.leecode.v101;

import java.util.Stack;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 说明:
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * 解题思路:
 * 树的左右子树是否对称，相当于是比较的两棵树
 *
 * 迭代:左右子树压栈，从栈中再取出比较
 *
 * 递归:
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
    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true; // 空树是对称的

        TreeNode left = root.left;
        TreeNode right = root.right;

        Stack<TreeNode> s  = new Stack();
        s.push(left);
        s.push(right);

        while (!s.isEmpty()){
            TreeNode p = s.pop();
            TreeNode q = s.pop();
            if(p == null && q == null) continue;//都为空继续
            if((p == null && q != null)
                    ||(p != null && q == null)) return false;// 其中一个为空

            if(p.val != q.val) return false; // 值不同

            s.push(p.left);s.push(q.right);
            s.push(p.right);s.push(q.left);
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);


        Solution s = new Solution();
        System.out.println(s.isSymmetric(root));

    }
}