package top.panson.top100.twopointer;

/**
 * @author Panson
 * @create 2025-06-26
 */
public class L005 {
    class Solution {
        public String longestPalindrome(String s) {
            int start = 0;
            int end = 0;
            int n = s.length();
            int maxlen = 0;
            for(int i = 0; i < s.length(); i++) {
                // 奇数
                int left =  i - 1;
                int right = i + 1;
                int len = 1;
                while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                    len += 2;
                    left--;
                    right++;
                }
                if(len > maxlen) {
                    start = left;
                    end = right;
                    maxlen = len;

                }

                // 偶数
                left = i;
                right = i + 1;
                len = 0;
                while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                    len += 2;
                    left--;
                    right++;
                }
                if(len > maxlen) {
                    start = left;
                    end = right;
                    maxlen = len;
                }
            }
            return s.substring(start + 1, end);
        }
    }
}
