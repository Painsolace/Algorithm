package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by HAOYUXING on 2020/7/20.
 */
public class Solution334 {


    /**
     * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
     *
     * 数学表达式如下:
     *
     * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
     * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
     * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,4,5]
     * 输出: true
     * 示例 2:
     *
     * 输入: [5,4,3,2,1]
     * 输出: false
     *
     * 链接：https://leetcode-cn.com/problems/increasing-triplet-subsequence
     *
     * 相似：300
     */

    public boolean increasingTriplet(int[] nums) {
        // 维护一个长度为3的链表
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (queue.isEmpty()) {
                queue.offer(nums[i]);
                continue;
            }
            if (nums[i] <= queue.peekFirst()) {
                queue.poll();
                queue.offerFirst(nums[i]);
            } else if (nums[i] > queue.peekLast()) {
                queue.offer(nums[i]);
                if (queue.size() == 3) {
                    return true;
                }
            } else {
                queue.pollLast();
                queue.offer(nums[i]);
            }
        }
        return queue.size() == 3;
    }

    // 两个数就可以
    public boolean increasingTripletV2(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = a;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= a) {
                a = nums[i];
            } else if (nums[i] > a && nums[i] <= b) {
                b = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
