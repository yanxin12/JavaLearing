// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-07 20:02
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.DataStruct.Tree;

public class RunTree {
    public static void main(String[] args) {
        Utils utils = new Utils();
//        int[] preorder = {28, 16, 13, 22, 30, 29, 43};
//        int[] inorder = {13, 16, 22, 28, 29, 30, 43};
        int[] preorder = {28, 20, 15, 25, 24, 26, 29};
        int[] inorder = {15, 20, 24, 25, 26, 28, 29};
//        int[] posorder = {13, 22, 16, 29, 43, 30, 28};
        TreeNode root = utils.preInOrederBuildTree(preorder, inorder);

//        TreeNode root = utils.constructSortTree(preorder);
//        System.out.println(root.left.left.parent.val);
        System.out.println(utils.TREE_PREDECESSOR(root.left.right.left).val);


        /**
         *
         //        utils.levelOrderTravel(root);
         //        TreeNode root = utils.preInOrederBuildTree(preorder, inorder);
         //        int[] treeData = {1, 2, 3, 4, 5, 6, 7, 8};
         //        TreeNode root = utils.constructTreeByInt(treeData, 0);
         //        utils.preSearch(root);
         //        System.out.println();
         //        System.out.println("-------------");
         //        if (root.right != null) {
         //            System.out.println(root.right.val);
         //        }
         //        utils.nopreRecursion(root);
         //        utils.noinRecursion(root);
         //        utils.noPosRecursion(root);
         */
    }
}
