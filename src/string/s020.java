package string;

import java.util.ArrayDeque;

// 20. 有效的括号
// 「栈」
public class s020 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        int len = s.length();
        if ((len & 1) == 1) return false;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                switch (c) {
                    case ')':
                        if (stack.pop()!='(') return false;
                        break;
                    case ']':
                        if (stack.pop()!='[') return false;
                        break;
                    case '}':
                        if (stack.pop()!='{') return false;
                        break;
                    default:
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        new s020().isValid("()");
    }
}
