// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-07 19:21
 * IDE: IntelliJ IDEA
 * Introduction:
 * 给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * <p>
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 * class Solution {
 * public TreeNode convertBST(TreeNode root) {
 * if(root == null){
 * return null;
 * }
 * root.val = searchTree(root.right, root.val);
 * // 遍历根节点的左子树的时候需要对左子树的最右节点进行初始化
 * if(root.left!=null){
 * initRightest(root.left,root.val);
 * }
 * convertBST(root.left);
 * convertBST(root.right);
 * return root;
 * }
 * public int searchTree(TreeNode root,int sum){
 * if(root == null){
 * // 当前节点为空，直接返回节点数之和
 * return sum;
 * }
 * // 当前子树不为空，加上当前节点的值，并且继续往下遍历
 * sum+=root.val;
 * int leftsum = searchTree(root.left,sum);
 * int allsum = searchTree(root.right,leftsum);
 * return allsum;
 * }
 * public void initRightest(TreeNode root,int val){
 * // 寻找根节点的最右节点，并且进行初始化
 * if(root==null){
 * return;
 * }
 * while(root.left!=null||root.right!=null){
 * if(root.right!=null){
 * root = root.right;
 * }
 * }
 * root.val = root.val + val;
 * }
 * <p>
 * }
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**class Solution {
 public TreeNode convertBST(TreeNode root) {
 if(root == null){
 return null;
 }
 root.val = searchTree(root.right, root.val);
 // 遍历根节点的左子树的时候需要对左子树的最右节点进行初始化
 if(root.left!=null){
 initRightest(root.left,root.val);
 }
 convertBST(root.left);
 convertBST(root.right);
 return root;
 }
 public int searchTree(TreeNode root,int sum){
 if(root == null){
 // 当前节点为空，直接返回节点数之和
 return sum;
 }
 // 当前子树不为空，加上当前节点的值，并且继续往下遍历
 sum+=root.val;
 int leftsum = searchTree(root.left,sum);
 int allsum = searchTree(root.right,leftsum);
 return allsum;
 }
 public void initRightest(TreeNode root,int val){
 // 寻找根节点的最右节点，并且进行初始化
 if(root==null){
 return;
 }
 while(root.left!=null||root.right!=null){
 if(root.right!=null){
 root = root.right;
 }
 }
 root.val = root.val + val;
 }

 }*/

package com.leetCode.convertBST;
public class convertBST {
    public static void searchTree(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        searchTree(root.left, sum);
        searchTree(root.right, sum);
    }

    public TreeNode convertBST_(TreeNode root) {
        // 1 所给的树是一颗二插搜索树
        // 2 原节点值替换为大于等于原节点值的和
        // 3 需要遍历节点的右子树，并且将遍历节点的值的和存储
        // 4 树的遍历需要采用递归方法，节点值的和需要变量进行保存
        // 5 采用递归实现的，从根节点递归到叶子节点
        // 6 只需递归查询节点的右子树
        int sum = 0;
        searchTree(root.right, sum);
        sum += root.val;
        root.val = sum;
        convertBST_(root.left);
        convertBST_(root.right);
        return root;
    }
}


