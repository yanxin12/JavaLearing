// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-27 12:42
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.findMode;

import com.DataStruct.Tree.TreeNode;


public class BigBullSolution {
    int maxcount = 0;
    private int[] ret;
    private int retcount = 0;
    private int count = 0;
    private TreeNode<Integer> pre;

    // copy大佬的解法
    // 求BST中的众数，使用两次中序排序
    public int[] findMode(TreeNode root) {
        inOrder(root);
        ret = new int[retcount];
        pre = null;
        count = 0;
        retcount = 0;
        inOrder(root);
        return ret;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (pre != null && root.val == pre.val) {
            count++;
        } else {
            count = 1;
            pre = root;
        }
        if (count == maxcount) {
            if (ret != null) {
                ret[retcount] = root.val;
            }
            ++retcount;
        } else if (count > maxcount) {
            maxcount = count;
            retcount = 1;
        }
        inOrder(root.right);
    }
}
