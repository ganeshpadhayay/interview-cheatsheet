package array.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class MergeIntervalsSolution {
    public static void main(String[] args) {
        MergeIntervalsSolution solution = new MergeIntervalsSolution();

        // Example 1
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result1 = solution.merge(intervals1);
        System.out.println("Merged intervals: ");
        for (int[] interval : result1) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }

        // Example 2
        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] result2 = solution.merge(intervals2);
        System.out.println("Merged intervals: ");
        for (int[] interval : result2) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }

    public int[][] merge(int[][] intervals) {
        //edge case
        if (intervals.length <= 1) return intervals;
        // Sort intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Initialize a list to hold the merged intervals
        List<int[]> result = new ArrayList<>();

        //add the first interval
        int[] current = intervals[0];
        result.add(current);

        // Iterate through the sorted intervals
        for (int[] next : intervals) {
            int currentEnd = current[1];
            int nextStart = next[0];
            int nextEnd = next[1];

            if (nextStart <= currentEnd) {
                // Overlapping, so merge
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, add new interval
                current = next;
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
