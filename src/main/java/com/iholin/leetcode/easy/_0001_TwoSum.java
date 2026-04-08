package com.iholin.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * Link: https://leetcode.com/problems/two-sum/description/
 */

/**
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class _0001_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int exp = target - nums[i];

            if (map.containsKey(exp)) {
                return new int[] {map.get(exp), i};
            }
            map.put(nums[i],i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        _0001_TwoSum solution = new _0001_TwoSum();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{23,66,9,2,7,11,15}, 9)));
    }
}
