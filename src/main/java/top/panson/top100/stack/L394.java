package top.panson.top100.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Panson
 * @create 2025-07-02
 */
public class L394 {

    class Solution {
        public String decodeString(String s) {
            Deque<String> strStack = new ArrayDeque<>();
            Deque<Integer> numStack = new ArrayDeque<>();
            StringBuilder currStr = new StringBuilder();
            int num = 0;

            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch)) {
                    num = num * 10 + (ch - '0');  // 支持多位数
                } else if (ch == '[') {
                    numStack.push(num);
                    strStack.push(currStr.toString());
                    currStr = new StringBuilder();
                    num = 0;
                } else if (ch == ']') {
                    int times = numStack.pop();
                    StringBuilder decoded = new StringBuilder(strStack.pop());
                    for (int i = 0; i < times; i++) {
                        decoded.append(currStr);
                    }
                    currStr = decoded;
                } else {
                    currStr.append(ch);
                }
            }

            return currStr.toString();
        }
    }

}
