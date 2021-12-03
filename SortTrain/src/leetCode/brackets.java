// -*- coding: utf-8 -*- 
/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-24 23:54
 * IDE: IntelliJ IDEA
 * Introduction:
 * /**
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 */
package leetCode;

import java.util.Stack;

public class brackets {
    public static void main(String[] args) {
//        String s = "(*)";
//        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
//        String s = "(((((*(()((((*((**(((()()**)()()()*(((()())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
//        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";

        if (matchBracket(s)) {
            System.out.println("配对成功！");
        } else {
            System.out.println("配对失败！");
        }

    }


    /**
     * @param s 程序应该访问到右括号的时候应该从右往左进行匹配
     *          见*消*，见（消（，而不是有优先级别
     */

    public static boolean matchBracket(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> leftBracket = new Stack<>();
        Stack<Character> startStack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                leftBracket.push(chars[i]);
            } else if (chars[i] == '*') {
                startStack.push(chars[i]);
            } else if (chars[i] == ')') {
                if (leftBracket.empty() && startStack.empty()) {
                    // 右括号出现多余，直接返回
                    return false;
                } else if (!(leftBracket.empty())) {
                    //先判断左括号
                    leftBracket.pop();
                } else if (!(startStack.empty())) {
                    //判断星号是否还存在
                    startStack.pop();
                }
            }
        }
        //实现左括号和*号的匹配
        while (!leftBracket.isEmpty()) {
            if (startStack.isEmpty()) return false;
            int posStack1 = leftBracket.pop();
            int posStack2 = startStack.pop();
            if (posStack1 > posStack2) {
                System.out.println("here");
                return false;
            }
        }
        return true;
    }

}
