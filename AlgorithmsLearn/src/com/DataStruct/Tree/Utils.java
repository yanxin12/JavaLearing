// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-07 19:52
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.DataStruct.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@SuppressWarnings({"all"})
public class Utils {
    // 实现树的先序遍历
    public void preSearch(TreeNode root) {
        if (root == null) {
            System.out.print("null\t");
            return;
        }
        System.out.print(root.val + "\t");
        preSearch(root.left);
        preSearch(root.right);
    }

    // 实现树的中序遍历
    public void midSearch(TreeNode root) {
        midSearch(root.left);
        System.out.println(root.val);
        midSearch(root.right);
    }

    // 实现树的后序遍历
    public void posSearch(TreeNode root) {
        preSearch(root.left);
        preSearch(root.right);
        System.out.println(root.val);
    }

    // 实现树的构造
    // 1 使用前序和中序序列构造二叉树

    /**
     * 通过前序序列确定二叉树的根节点
     * 通过中序序列确定二叉树左子树和右子树位置
     * 前序序列的第一个元素是二叉树的根节点
     * 通过Map存储二叉树节点信息
     */
    public TreeNode preInOrederBuildTree(int[] pre, int[] in) {
        Map inMap = toMap(in);
        TreeNode root = buildTree(pre, inMap, 0, pre.length - 1, 0);
        return root;
    }


    /**
     * @param pre     前序序列数据
     * @param in      中序序列数据
     * @param start   前序序列起点
     * @param end     前序序列终点
     * @param instart 中序序列起点
     * @return
     */
    protected TreeNode buildTree(
            int[] pre, Map<Integer, Integer> in, int start, int end, int instart) {
        // 递归结束条件
        if (start > end) {
            return null;
        }
        // 获取中序序列中根节点索引
        int rootIndex = in.get(pre[start]);
        // 确定树的左子树和右子树的长度
        int leftLen = rootIndex - instart;
        // 创建节点
        TreeNode root = new TreeNode<>();
        root.val = pre[start];
        // 递归创建
        root.left = buildTree(pre, in, start + 1, start + leftLen, instart);
        root.right = buildTree(pre, in, start + leftLen + 1, end, rootIndex + 1);
        return root;
    }

    // 实现将数据转换为Map结构存储
    // 为了实现从前序序列定位中序序列根节点的位置
    public Map toMap(int[] data) {
        if (data.length == 0) {
            return null;
        }
        Map<Integer, Integer> dataMap = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            dataMap.put(data[i], i);
        }

        return dataMap;
    }

    // 2 通过中序和后序序列构造二叉树
    public TreeNode constructTreeByInPos(int[] in, int[] pos) {
        Map map = toMap(in);
        TreeNode root = inPosOrder(
                map, pos, 0, pos.length - 1, pos.length - 1);
        return root;
    }

    public TreeNode inPosOrder(
            Map<Integer, Integer> inMap, int[] pos, int start, int end, int inend) {
        // 递归结束条件
        if (start > end) {
            return null;
        }
        // 获取根节点在中序序列中的索引
        int rootIndex = inMap.get(pos[end]);
        // 获取右子树数据长度
        int rightLen = inend - rootIndex;
        // 构造节点，后序序列的最后一个数字是根节点数值
        TreeNode<Integer> root = new TreeNode<>();
        root.val = pos[end];
        // 递归构造
        root.left = inPosOrder(
                inMap, pos, start, end - rightLen - 1, rootIndex - 1);
        root.right = inPosOrder(
                inMap, pos, end - rightLen, end - 1, inend);
        return root;
    }

    // 方法实现查找a在Array数组数组的索引
    // 假设a在数组中唯一存在
    public int getIndex(int a, int[] Array) {
        for (int i = 0; i < Array.length; i++) {
            if (a == Array[i]) {
                return i;
            }
        }
        System.out.println(a + "不存在数组中！");
        return -1;
    }

    // 递归建立一颗完全二叉树
    // 传入的数据形式为整形数组
    public TreeNode constructTreeByInt(int[] treedata, int i) {
        if (i >= treedata.length) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = treedata[i];
        root.left = constructTreeByInt(treedata, 2 * i + 1);
        root.right = constructTreeByInt(treedata, 2 * i + 2);
        return root;
    }

    /**
     * 实现树的前序非递归遍历
     *
     * @param root 需要遍历树的根节点
     *             使用辅助栈存放节点信息
     *             首先遍历完树的左节点，遍历完之后一次取出存储在栈中的节点
     *             使用while实现右节点
     *             当栈和p节点指针都为空的时候，遍历完成
     */
    public void nopreRecursion(TreeNode root) {
        // 辅助栈，存放根节点
        Stack<TreeNode> auxiliaryStack = new Stack<>();
        // 遍历指针
        TreeNode<Integer> p = root;
        // 只要p或者栈未空，则树还没有遍历完
        while (p != null || !auxiliaryStack.isEmpty()) {
            // 遍历根节点左节点
            while (p != null) {
                System.out.print(p.val + "\t");
                auxiliaryStack.push(p);
                p = p.left;
            }
            // 遍历完所有左边节点之后，取出存储在栈中的节点
            // 一次实现右节点的遍历
            if (!auxiliaryStack.isEmpty()) {
                p = auxiliaryStack.pop();
                p = p.right;
            }
        }
    }

    /**
     * 实现树的中序非递归遍历
     *
     * @param root 需要遍历的树的根节点
     *             需要找到树的最左节点，然后一次访问其父节点和父节点的右节点
     *             需要使用辅助栈存储节点信息
     */
    public void noinRecursion(TreeNode root) {
        // 辅助栈，存放根节点
        Stack<TreeNode> auxiliaryStack = new Stack<>();
        // 遍历指针
        TreeNode<Integer> p = root;
        while (p != null || !auxiliaryStack.isEmpty()) {
            // 找到树的最左节点
            while (p != null) {
                auxiliaryStack.push(p);
                p = p.left;
            }
            if (!auxiliaryStack.isEmpty()) {
                p = auxiliaryStack.pop();
                System.out.print(p.val + "\t");
                p = p.right;
            }
        }


    }

    /**
     * 实现树的后序非递归遍历
     *
     * @param root 需要遍历的树的根节点
     *             使用一个辅助栈，通过判断栈顶元素出现的次数实现后序遍历
     *             需要使用辅助变量isFirst
     */
    public void noposRecursion(TreeNode root) {
        // 辅助栈，存放根节点
        Stack<TreeNode> auxiliaryStack = new Stack<>();
        // 遍历指针
        TreeNode<Integer> p = root;
        while (p != null || !auxiliaryStack.isEmpty()) {
            // 找到树的最左节点
            while (p != null) {
                auxiliaryStack.push(p);
                p = p.left;
            }
            if (!auxiliaryStack.isEmpty()) {
                p = auxiliaryStack.pop();
                if (p.isFirst) {
                    p.setFirst();
                    auxiliaryStack.push(p);
                    p = p.right;
                } else {
                    // 栈顶元素为第二次出现
                    // 当栈顶元素为第二次进栈的时候说明已经将树的右子树访问完毕
                    System.out.print(p.val + "\t");
                    // 需要将p置为空，防止三次进栈
                    p = null;
                }
            }

        }
    }

    /**
     * 树的后序非递归遍历的第二种思路
     * 使用前指针判断节点的左右指针是否被访问过
     */
    public void noPosRecursion(TreeNode root) {
        // 辅助栈，存放根节点
        Stack<TreeNode> auxiliaryStack = new Stack<>();
        // 初始化指针
        TreeNode<Integer> cur = null;
        TreeNode<Integer> pre = null;
        // pre 节点跟随左右节点的步伐
        auxiliaryStack.push(root);
        while (!auxiliaryStack.isEmpty()) {
            cur = auxiliaryStack.peek();
            if ((cur.left == null && cur.right == null) ||
                    (pre != null && (pre == cur.left || pre == cur.right))) {
                // 当访问到根节点或者当前节点的子节点全部访问后，直接输出
                System.out.print(auxiliaryStack.pop().val + "\t");
                pre = cur;
            } else {
                // 入栈之前需要判断是否为空，防止空指针异常
                if (cur.right != null) {
                    auxiliaryStack.push(cur.right);
                }
                if (cur.left != null) {
                    auxiliaryStack.push(cur.left);
                }
            }

        }
    }


}
