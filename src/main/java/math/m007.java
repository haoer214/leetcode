package math;

// 7. 整数反转
// (字符串转换的效率较低且使用较多库函数，不推荐。可通过数学计算来解决)
public class m007 {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            // 除法、取余运算会保留负号
            int pop = x % 10;
            // 判断是否溢出（上限）
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            // 判断是否溢出（下限）
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            ans = ans * 10 + pop;
            x = x / 10;
        }
        return ans;
    }
    public static void main(String[] args){
        int a = -123;
        int pop = a % 10;
        a = a / 10;
        // a = -12, pop = -3
        System.out.println("a = " + a + "; pop = " + pop);
    }
}
