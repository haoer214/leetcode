package math;

import java.util.HashMap;

// 13. 罗马数字转整数
// 建立「哈希表」
public class m013 {
    public int romanToInt(String s) {
        int[] alab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < roman.length; i++) {
            map.put(roman[i],alab[i]);
        }
        int ans = 0;
        while (!s.isEmpty()) {
            if (s.length() >= 2 && map.containsKey(s.substring(0, 2))) {
                ans += map.get(s.substring(0, 2));
                s = s.substring(2);
            } else {
                ans += map.get(s.substring(0, 1));
                s = s.substring(1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new m013().romanToInt("III"));
    }
}
