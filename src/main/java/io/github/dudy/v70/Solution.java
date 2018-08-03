package io.github.dudy.v70;

/**
 * 假设你正在爬楼梯。需要 n 步你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 步 + 1 步
 * 2.  2 步
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 步 + 1 步 + 1 步
 * 2.  1 步 + 2 步
 * 3.  2 步 + 1 步
 */
class Solution {
    public int climbStairs(int n) {

        if (0 == n || 1 == n || 2 == n) {
            return n;
        }

        int r[] = new int[n+1];

        r[1] = 1;
        r[2] = 2;
        for (int i = 3; i <= n; i++) {
            r[i] = r[i - 1] + r[i - 2];
        }

        return r[n];

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(3));
        System.out.println(s.climbStairs(20));

    }
}