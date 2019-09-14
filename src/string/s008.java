package string;

// 8. 字符串转换整数 (atoi)
public class s008 {
    public int myAtoi(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        String newStr = str.trim();
        char firstChar = newStr.charAt(0);
        if ((firstChar < 48 || firstChar > 57) && (firstChar != 43 && firstChar != 45)) {
            return 0;
        }
        String sign = "";
        String numStr;
        if (firstChar == 45) {
            sign = "-";
            numStr = sign;
        } else if (firstChar == 43) {
            numStr = "";
        } else {
            numStr = newStr.substring(0, 1);
        }
        for (int i = 1; i < newStr.length(); i++) {
            if (newStr.charAt(i) >= 48 && newStr.charAt(i) <= 57) {
                numStr += newStr.substring(i, i + 1);
            } else {
                break;
            }
        }
        if (numStr.equals("") || numStr.equals("-")) {
            return 0;
        }
        int ans;
        // 判断是否越界
        try {
            ans = Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            if (sign.equals("-"))
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new s008().myAtoi("3.1415926"));
    }

}