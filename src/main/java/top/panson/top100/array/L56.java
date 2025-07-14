package top.panson.top100.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Panson
 * @create 2025-07-14
 */
public class L56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            int n = intervals.length;
            if(n < 2) {
                return intervals;
            }
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            List<int[]> res = new ArrayList<>();
            int start = intervals[0][0];
            int end = intervals[0][1];
            // 先加入结果数据
            res.add(new int[]{start, end});
            for(int i = 1; i < n; i++) {
                // 不相交
                if(end < intervals[i][0]) {
                    start = intervals[i][0];
                    end = intervals[i][1];
                    res.add(new int[]{start, end});
                } else {
                    // 相交
                    end = Math.max(end, intervals[i][1]);
                    res.get(res.size() - 1)[1] = end;
                }
            }
            return res.toArray(new int[0][]);

        }
    }
}
