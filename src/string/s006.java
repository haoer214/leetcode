package string;

import java.util.OptionalInt;

// 6. Z字型变换
// 时间：O(n)  空间：O(n)
public class s006 {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() < numRows) {
            return s;
        }
        String[] strs = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            strs[i] = "";
        }
        boolean down = false;
        int location = 0;
        for (int i = 0; i < s.length(); i++) {
            strs[location] += s.substring(i, i + 1);
            if (location == 0 || location == numRows-1)
                down = !down;
            location += down ? 1 : -1;
        }
        String ans = "";
        for (String str : strs) {
            ans += str;
        }
        return ans;
    }
}
