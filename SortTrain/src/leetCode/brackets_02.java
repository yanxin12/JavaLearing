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

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Stack;

public class brackets_02 {
    public static void main(String[] args) {
//        String s = "(*)";
//        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
//        String s = "(((((*(()((((*((**(((()()**)()()()*(((()())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";

        if (matchBracket(s)) {
            System.out.println("配对成功！");
        } else {
            System.out.println("配对失败！");
        }

    }


    public static boolean matchBracket(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> leftstrartBracket = new Stack<>();
        // 创建一个单独的栈，栈内按顺序存储左括号和*，当String出现）的时候
        // 从栈顶取出元素
        // 当String遍历完成之后还要检测栈内*的数量是否大于)
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '*') {
                leftstrartBracket.push(chars[i]);
            } else if (chars[i] == ')') {
                if (leftstrartBracket.empty()) {
                    // 右括号出现多余，直接返回
                    return false;
                } else if (!(leftstrartBracket.empty())) {
                    //在右括号前面存在*和）可以进行匹配
                    leftstrartBracket.pop();
                }
            }
        }
        // 遍历完成之后还需要检查(个数是否小于*
        Iterator<Character> iterator = leftstrartBracket.iterator();
        int leftBracketsNums = 0;
        int startNums = 0;
        while (iterator.hasNext()) {
            Character next = iterator.next();
            if (next == '(') {
                ++leftBracketsNums;
            } else {
                ++startNums;
            }
        }
        return startNums >= leftBracketsNums;

    }




    @Test
    public void shoutNums() {
        int leftBracket = 0;
        int start = 0;
        String s = "(((((*(*********((*(((((****";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                ++leftBracket;
            } else {
                ++start;
            }
        }
        System.out.println("leftBracket:\t" + leftBracket);
        System.out.println("start:\t" + start);
    }

}