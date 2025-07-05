package top.panson.top100.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panson
 * @create 2025-07-05
 */
public class L22 {


    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            StringBuilder path = new StringBuilder();
            backtrack(n, res, path, 0, 0);
            return res;
        }

        public void backtrack(int n, List<String> res, StringBuilder path, int openCount, int closeCount) {
            if(path.length() == n * 2) {
                res.add(path.toString());
                return;
            }

            if(openCount < n) {
                path.append("(");
                backtrack(n, res, path, openCount + 1, closeCount);
                path.deleteCharAt(path.length() - 1);
            }

            if(closeCount < openCount) {
                path.append(")");
                backtrack(n, res, path, openCount, closeCount + 1);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }



}
