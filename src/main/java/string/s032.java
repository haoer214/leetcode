package string;

import java.util.ArrayDeque;

/**
 * 32. 最长有效括号
 */
public class s032 {
    // ①动态规划：时间O(n)，空间O(n)
//    public int longestValidParentheses(String s) {
//        int max = 0;
//        int[] dp = new int[s.length()];
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i) == ')') {
//                if (s.charAt(i - 1) == '(') {
//                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
//                } else {
//                    if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
//                        dp[i] = dp[i - 1] + ((i - dp[i - 1] - 1) > 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
//                    }
//                }
//            }
//            max = Math.max(max, dp[i]);
//        }
//        return max;
//    }

    //②栈：时间O(n)，空间O(n)
    public int longestValidParentheses(String s) {
        int max = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    max = Math.max(max, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return max;
    }

    //③左右扫描：时间O(n)，空间O(1)
    //利用两个计数器 left 和 right

}
