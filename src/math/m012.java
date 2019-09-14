package math;

// 12. 整数转罗马数字
// 「贪心算法」
public class m012 {
    public String intToRoman(int num) {
        int[] alab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder ans = new StringBuilder();
        int index = 0;
        while (index < alab.length) {
            while (num >= alab[index]) {
               ans.append(roman[index]);
               num -= alab[index];
            }
            index++;
        }
        return ans.toString();
    }
}
