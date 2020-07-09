import java.util.Stack;

public class ValidParenthesesSolution {

    public boolean isValid(String s) {
        String parentheses = s;
        ArrayStack<Character> stack = new ArrayStack<>();
        //遍历输入的字符串
        for (int i = 0; i < parentheses.length(); i++) { //循环变量字符串String String可以用.length()
            char c = parentheses.charAt(i);       // 获得字符串中的某个位置的字符 charAt(index)
            //注意这里 如果“(”代表字符串   ‘(’代表字符Char
            if (c == '{' || c == '[' || c == '(') { //左括号入栈
                stack.push(c);
            }else { //右括号或者其他进行判断是否对称相等
                if (c != '}' && c != ')' && c != ']') { //即将判断的元素不是右括号的情况，返回错误
                    return false;
                }
                if (stack.isEmpty()) { //如果栈是空的，下面根本没法pop，需要先排除
                    return false;
                }
                char topChar = stack.pop();//查看栈顶的元素
                if (c == '}' && topChar != '{') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == ')' && topChar != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty(); //全部String遍历完，栈也为空，才可以过
    }

    public static void main(String[] args) {
        System.out.println(new ValidParenthesesSolution().isValid("{([])}"));
        System.out.println(new ValidParenthesesSolution().isValid("[](){}"));
    }
}
