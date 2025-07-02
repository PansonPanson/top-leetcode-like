package top.panson.top100.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Panson
 * @create 2025-07-02
 */
public class L739 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> stack = new ArrayDeque<>();
            int n = temperatures.length;
            int[] res = new int[n];
            for(int i = n - 1; i >= 0; i--) {
                // 因为是从后往前入栈，所以实际上是从前往后弹出的，执行完该 while 逻辑，留下的都是比当前数大的数的下标
                while(!stack.isEmpty() &&  temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
                stack.push(i);
            }
            return res;
        }
    }
}
