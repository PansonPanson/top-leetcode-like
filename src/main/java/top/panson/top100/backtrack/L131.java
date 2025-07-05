package top.panson.top100.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2025-07-05
 */
public class L131 {
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            List<String> path = new ArrayList<>();
            backtrack(s, res, 0, path);
            return res;
        }

        public void backtrack(String s, List<List<String>> res, int start, List<String> path) {

            if(start == s.length()) {
                res.add(new ArrayList<>(path));
                return;
            }
            // 开始先固定一[0, i] 为前缀，判断是否回文，接着递归递归判断[i + 1, n - 1]
            for(int i = start; i < s.length(); i++) {
                if(isValid(s, start, i)) {
                    path.add(s.substring(start, i + 1));
                    backtrack(s, res, i + 1, path);
                    path.remove(path.size() - 1);
                }
            }
        }

        public  boolean isValid(String s, int left, int right) {
            while(left < right) {
                if(s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
