package array.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a solution to the "Two Sum" problem from LeetCode.
 * <p>
 * The problem involves finding two numbers in an array that add up to a given target.
 * The solution returns the indices of these two numbers.
 * <p>
 * Features:
 * <ul>
 *   <li>Efficient implementation using a HashMap for O(n) time complexity.</li>
 *   <li>Handles multiple test cases in the main method for demonstration purposes.</li>
 * </ul>
 *
 * <p><b>Method Details:</b></p>
 * <ul>
 *   <li><b>twoSum:</b> Finds the indices of two numbers in the array that add up to the target.</li>
 * </ul>
 *
 * <p><b>Examples:</b></p>
 * <pre>
 * Example 1:
 * Input: nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1]
 * Explanation: nums[0] + nums[1] == 9, so we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3, 2, 4], target = 6
 * Output: [1, 2]
 * Explanation: nums[1] + nums[2] == 6, so we return [1, 2].
 *
 * Example 3:
 * Input: nums = [3, 3], target = 6
 * Output: [0, 1]
 * Explanation: nums[0] + nums[1] == 6, so we return [0, 1].
 * </pre>
 *
 * <p><b>Constraints:</b></p>
 * <ul>
 *   <li>2 <= nums.length <= 10^4</li>
 *   <li>-10^9 <= nums[i] <= 10^9</li>
 *   <li>-10^9 <= target <= 10^9</li>
 *   <li>Only one valid answer exists.</li>
 * </ul>
 *
 * <p><b>Usage:</b></p>
 * <pre>
 * TwoSumSolution solution = new TwoSumSolution();
 * int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
 * System.out.println(Arrays.toString(result)); // Output: [0, 1]
 * </pre>
 */
class TwoSumSolution {

    public static void main(String[] args) {
        TwoSumSolution solution = new TwoSumSolution();

        // Test case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Result for nums1: " + Arrays.toString(result1));

        // Test case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Result for nums2: " + Arrays.toString(result2));

        // Test case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Result for nums3: " + Arrays.toString(result3));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                answer[0] = map.get(nums[i]);
                answer[1] = i;
                break;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return answer;
    }

}