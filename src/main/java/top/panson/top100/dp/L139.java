package top.panson.top100.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Panson
 * @create 2025-06-28
 */
public class L139 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            // dp[i] : 前 i 个字符可以被拆分
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for(int i = 1; i <= s.length(); i++) {
                for(int j = 0; j < i; j++) {
                    if(dp[j] && set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }
}
