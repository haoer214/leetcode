package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 17. 电话号码的字母组合
//「回溯」是一种通过穷举所有可能情况来找到所有解的算法
// 如果一个候选解最后被发现并不是可行解，回溯算法会舍弃它，并在前面的一些步骤做出一些修改，并重新尝试找到可行解
public class s017 {
    // 第一层括弧实际是定义了一个匿名内部类 (Anonymous Inner Class)，
    // 第二层括弧实际上是一个实例初始化块 (instance initializer block)，这个块在内部匿名类构造时被执行
    Map<String, String> phone = new HashMap<String, String>() {
        {
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
        }
    };
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits != null && digits.length()!= 0) {
            backTrack("",digits);
        }
        return list;
    }
    private void backTrack(String combination, String next_digits){
        if (next_digits.length() == 0) {
            list.add(combination);
        } else {
            String letters = phone.get(next_digits.substring(0, 1));
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backTrack(combination + letter, next_digits.substring(1));
            }
        }
    }
}
