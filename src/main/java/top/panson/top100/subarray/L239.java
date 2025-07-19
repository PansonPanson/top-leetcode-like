package top.panson.top100.subarray;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Panson
 * @create 2025-07-19
 */
public class L239 {


    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || k == 0) return new int[0];

            int n = nums.length;
            int[] result = new int[n - k + 1]; // 结果数组，窗口个数为 n - k + 1
            // deque 维护的是当前滑动窗口中可能成为最大值的元素的 下标索引，并且按其对应的数值保持单调递减（从队头到队尾）
            // 队头存的是最早入队的元素
            Deque<Integer> deque = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                // 🔹 1. 移除窗口外的索引
                // 如果队头索引已经滑出窗口左边（即 i - k），就移除
                if (!deque.isEmpty() &&  i - deque.peekFirst() > k - 1) {
                    deque.pollFirst();
                }

                // 🔹 2. 维护队列的单调性：从队尾开始，移除所有比当前值小的索引
                // 因为当前值更大，它们不可能成为未来的最大值
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }

                // 🔹 3. 添加当前元素的索引到队列尾部
                deque.offerLast(i);

                // 🔹 4. 当窗口已经形成（即 i >= k - 1），记录窗口最大值（队头所指的索引对应的值）
                if (i >= k - 1) {
                    result[i - k + 1] = nums[deque.peekFirst()];
                }
            }

            return result;
        }
    }

}
