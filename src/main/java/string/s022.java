package string;

import java.util.ArrayList;
import java.util.List;

// 22. 括号生成
//「回溯」
public class s022 {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backTrack("",0,0,n);
        return ans;
    }
    private void backTrack(String combination, int open, int close, int max) {
        if (combination.length() == max*2) {
            ans.add(combination);
            return;
        }
        if (open < max) {
            backTrack(combination + "(", open + 1, close, max);
        }
        if (open > close && close < max) {
            backTrack(combination + ")", open, close + 1, max);
        }
    }
}
