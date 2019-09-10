package string;

// 5、最长回文字串
public class s005 {
    // ①暴力法: 时间O(n3) ; 空间O(1)

    // ②动态规划(空间换时间): 时间O(n2) ; 空间O(n2),用到二维数组
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 0;
        String maxSubstr = "";
        boolean[][] p = new boolean[n][n];
        for (int len=1;len<=n;len++){
            for (int start=0;start<n;start++){
                int end = start+len-1;
                if(end >= n){
                    break;
                }
                p[start][end] = (len==1 || len==2 || p[start+1][end-1])
                        && s.charAt(start)==s.charAt(end);
                if (p[start][end] && len>maxLength){
                    maxLength = len;
                    maxSubstr = s.substring(start,end+1);
                }
            }
        }
        return maxSubstr;
    }
    // ③最长公共字串(倒置+判断): 时间O(n2) ; 空间O(n2),用到二维数组

    // ④扩展中心: 时间O(n2) ; 空间O(1)

    // ⑤Manacher's Algorithm 马拉车算法: 时间O(n) ; 空间O(n)

}
