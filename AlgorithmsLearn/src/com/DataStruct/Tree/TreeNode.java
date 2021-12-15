// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-07 19:21
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.DataStruct.Tree;

public class TreeNode<T> {
    // 用于实现树的后序非递归遍历
    protected boolean isFirst = true;
    T val;
    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode<T> parent;

    TreeNode() {
    }

    TreeNode(T val) {
        this.val = val;
    }

    public TreeNode(boolean isFirst, T val, TreeNode<T> left, TreeNode<T> right, TreeNode<T> parent) {
        this.isFirst = isFirst;
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst() {
        isFirst = false;
    }
}


