package array.twopointers;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * <p>
 * Return the sum of the three integers.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 * <p>
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 500
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
public class ThreeSumClosestSolution {

    public static void main(String[] args) {
        ThreeSumClosestSolution solution = new ThreeSumClosestSolution();
        // Example 1
        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;
        System.out.println("Closest sum to target " + target1 + " is: " + solution.threeSumClosest(nums1, target1));

        // Example 2
        int[] nums2 = {0, 0, 0};
        int target2 = 1;
        System.out.println("Closest sum to target " + target2 + " is: " + solution.threeSumClosest(nums2, target2));

        // Additional Example 1
        int[] nums3 = {1, 1, 1, 0};
        int target3 = 100;
        System.out.println("Closest sum to target " + target3 + " is: " + solution.threeSumClosest(nums3, target3));

        // Additional Example 2
        int[] nums4 = {-3, -2, -5, 3, -4};
        int target4 = -1;
        System.out.println("Closest sum to target " + target4 + " is: " + solution.threeSumClosest(nums4, target4));
    }


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE; // Initialize closestSum to a large value
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum; // Update closestSum if currentSum is closer to target
                }
                if (currentSum < target) {
                    left++; // Move left pointer to increase the sum
                } else if (currentSum > target) {
                    right--; // Move right pointer to decrease the sum
                } else {
                    return currentSum; // Return immediately if exact match is found
                }
            }
        }
        return closestSum; // Return the closest sum found
    }
}
