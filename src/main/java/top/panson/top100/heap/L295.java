package top.panson.top100.heap;

import java.util.PriorityQueue;

/**
 * @author Panson
 * @create 2025-07-01
 */
public class L295 {

    class MedianFinder {
        // 最大堆（左边），存较小的一半
        private PriorityQueue<Integer> left;
        // 最小堆（右边），存较大的一半
        private PriorityQueue<Integer> right;

        public MedianFinder() {
            left = new PriorityQueue<>((a, b) -> b - a); // 大顶堆
            right = new PriorityQueue<>();               // 小顶堆
        }

        public void addNum(int num) {
            // 默认先加到左边（大顶堆）
            left.offer(num);

            // 把最大值放到右边堆，保持左边所有元素 <= 右边所有元素
            right.offer(left.poll());

            // 如果右边堆比左边大，移动一个回左边，保持 size 平衡
            if (right.size() > left.size()) {
                left.offer(right.poll());
            }
        }

        public double findMedian() {
            if (left.size() > right.size()) {
                return left.peek(); // 奇数时，中位数在左边
            } else {
                return (left.peek() + right.peek()) / 2.0; // 偶数时，取两边平均
            }
        }
    }

}
