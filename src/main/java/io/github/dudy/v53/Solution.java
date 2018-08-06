package io.github.dudy.v53;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
class Solution {
    public int maxSubArray(int[] nums) {

        int maxNum ;int thisSum;
        maxNum = thisSum= nums[0];
        if(nums.length <=1) return maxNum;

        for (int i = 1;i<nums.length ; i++) {

            if(thisSum <=0 )
                thisSum = nums[i];
            else
                thisSum = thisSum + nums[i];
            if(thisSum > maxNum){
                maxNum = thisSum;
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,-3,-4,-1,-2,-1,-5,-4};
        Solution s = new Solution();
        System.out.println(s.maxSubArray(nums));

    }
}