package top.panson.top100.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Panson
 * @create 2025-07-04
 */
public class L017 {

    class Solution {
        private static final Map<Character, String> phoneMap = Map.of(
                '2', "abc", '3', "def",
                '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs",
                '8', "tuv", '9', "wxyz"
        );

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if(digits == null || digits.length() == 0 || digits.trim() == "") {
                return res;
            }
            backtrack(digits, res, new StringBuilder(), 0);
            return res;
        }

        public void backtrack(String digits, List<String> res, StringBuilder path, int index) {
            if(index == digits.length()) {
                res.add(path.toString());
                return;
            }

            String curString = phoneMap.get(digits.charAt(index));

            for(char ch : curString.toCharArray()) {
                path.append(ch);
                backtrack(digits, res, path, index + 1);
                path.deleteCharAt(path.length() - 1);
            }
        }


    }

}
