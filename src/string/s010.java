package string;

// 10. 正则表达式匹配
public class s010 {
    // ①回溯（递归）
    // 递归过程中出现了「重叠子问题」，可用动态规划来解决
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean first_match = !s.isEmpty() &&
                (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) ||
                    first_match && isMatch(s.substring(1), p);
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
    // ②动态规划
    // 使用两个变量 i, j 记录当前匹配到的位置，避免使用子字符串切片
}
