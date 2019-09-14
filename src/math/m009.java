package math;

// 9. 回文数
// # 提高要求：不转换为字符串
public class m009 {
    // ①转换为字符串
//    public boolean isPalindrome(int x) {
//        String str = Integer.toString(x);
//        String rStr = "";
//        int n = str.length();
//        while (n > 0) {
//            rStr += str.substring(n - 1, n);
//            n--;
//        }
//        if (rStr.equals(str))
//            return true;
//        return false;
//    }
    // ②不使用字符串
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int ori = x;
        int ans = 0;
        while (x != 0) {
            int re = x % 10;
            ans = ans * 10 + re;
            x /= 10;
        }
        if (ans == ori)
            return true;
        return false;
    }
}
