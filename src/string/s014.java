package string;

// 14. 最长公共前缀
public class s014 {
    // ①水平扫描法  时间复杂度 O(S), S 是所有字符串中字符数量的总和
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.isEmpty()) {
                return "";
            }
        }
        return prefix;
    }

    // ②二分查找  时间复杂度 O(S⋅log(n))

    public static void main(String[] args){}
}
