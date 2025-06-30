package top.panson.top100.dp;

/**
 * @author Panson
 * @create 2025-06-30
 */
public class L032 {

    class Solution {
        public int longestValidParentheses(String s) {
            int n = s.length();
            // dp[i]：以 s[i] 结尾的最长有效括号的长度
            int[] dp = new int[n];
            int maxLen = 0;

            for (int i = 1; i < n; i++) {
                // 如果当前是 '('，不可能以它结尾组成有效括号，直接跳过
                if (s.charAt(i) == '(') {
                    continue;
                }

                // 当前是 ')'，且前一个是 '('，形如："()"
                if (s.charAt(i - 1) == '(') {
                    // 加上前面已经配对好的部分
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;

                    // 当前是 ')'，且前一个也是 ')'，要查找前面配对的 '('
                } else {
                    // 找到与当前 ')' 匹配的 '(' 的下标
                    int preIndex = i - dp[i - 1] - 1;

                    // preIndex >= 0 并且那一位是 '(' 才能构成有效括号
                    if (preIndex >= 0 && s.charAt(preIndex) == '(') {
                        // dp[i - 1] 是已经配对好的部分
                        // dp[preIndex - 1] 是 '(' 之前可能配对好的部分（注意边界）
                        dp[i] = dp[i - 1] + 2 + (preIndex >= 1 ? dp[preIndex - 1] : 0);
                    }
                }

                // 更新最长结果
                maxLen = Math.max(maxLen, dp[i]);
            }

            return maxLen;
        }
    }

}
