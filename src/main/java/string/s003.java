package string;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 3、无重复字符的最长字串
public class s003 {
    // ①暴力解法 时间O(n2)
//    public int lengthOfLongestSubstring(String s) {
//        if (s==null || s.length()==0){
//            return 0;
//        }
//        int maxSubstr = 1;
//        Set<Character> set = new HashSet<>();
//        for (int i=0;i<s.length();i++){
//            if(maxSubstr>=s.length()-i){
//                break;
//            }
//            int tmpSubstr = 1;
//            set.add(s.charAt(i));
//            for (int j=i+1;j<s.length();j++){
//                if (set.contains(s.charAt(j))){
//                    set.clear();
//                    break;
//                }
//                else{
//                    set.add(s.charAt(j));
//                    tmpSubstr++;
//                }
//            }
//            if (maxSubstr<tmpSubstr){
//                maxSubstr = tmpSubstr;
//            }
//        }
//        return maxSubstr;
//    }

    // ②滑动窗口（双指针） 时间O(n)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0,j=0;j<n;j++){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(i,map.get(s.charAt(j)));
            }
            ans = Math.max(ans,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return ans;
    }
}
