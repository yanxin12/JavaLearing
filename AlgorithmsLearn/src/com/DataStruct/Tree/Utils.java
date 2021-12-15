// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-07 19:52
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.DataStruct.Tree;

import java.util.*;

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
        if (root != null) {
            midSearch(root.left);
            System.out.print(root.val + "\t");
            midSearch(root.right);
        }
    }

    // 实现树的后序遍历
    public void posSearch(TreeNode root) {
        if (root == null) {
            return;
        }
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
     * 前序中序序列构造二叉树
     *
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
        if (root.left != null) {
            root.left.parent = root;
        }
        if (root.right != null) {
            root.right.parent = root;
        }
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
        if (root.left != null) {
            root.left.parent = root;
        }
        if (root.right != null) {
            root.right.parent = root;
        }
        return root;
    }

    // 方法实现查找a在Array数组数组的索引,假设a在数组中唯一存在
    public int getIndex(int a, int[] Array) {
        for (int i = 0; i < Array.length; i++) {
            if (a == Array[i]) {
                return i;
            }
        }
        System.out.println(a + "不存在数组中！");
        return -1;
    }

    // 递归建立一颗完全二叉树,传入的数据形式为整形数组
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
        if (root == null) {
            return;
        }
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
        if (root == null) {
            return;
        }
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
        if (root == null) {
            return;
        }
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
        if (root == null) {
            return;
        }
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

    /**
     * 实现二叉树的层次遍历
     * 使用辅助队列
     *
     * @param root
     */
    public void levelOrderTravel(TreeNode root) {
        // 初始化辅助队列
        Queue<TreeNode> auxiliaryQueue = new LinkedList<>();
        auxiliaryQueue.add(root);
        while (!auxiliaryQueue.isEmpty()) {
            TreeNode tmpNode = auxiliaryQueue.element();
            // 孩子按顺序入队列
            if (tmpNode.left != null) {
                auxiliaryQueue.add(tmpNode.left);
            }
            if (tmpNode.right != null) {
                auxiliaryQueue.add(tmpNode.right);
            }
            System.out.print(auxiliaryQueue.poll().val + "\t");
        }

    }

    /**
     * 实现二叉树的孩子兄弟转化
     * 需要使用辅助栈
     */
    public TreeNode biToSiblingTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> auxiliaryStack = new Stack<>();
        auxiliaryStack.push(root);
        TreeNode p = root;
        TreeNode q = null;
        while (!auxiliaryStack.isEmpty()) {
            // 从最左叶子节点开始，思路是树的连线法
            while (p != null) {
                auxiliaryStack.push(p);
                p = p.left;
            }
            p = auxiliaryStack.peek();
            if (p.right != null) {
                p.left = p.right;
                p = p.left;
            } else {
                auxiliaryStack.pop();
                // 避免出现根节点出栈之后出现空指针异常
                if (auxiliaryStack.isEmpty()) {
                    return root;
                }
                // 此时的栈顶节点为当前节点的父节点
                q = auxiliaryStack.peek();
                // 如果当前节点的父节点有右子树，则将右子树连给当前节点，并且对父节点的右子树实现连线操作
                if (q.right != null) {
                    p.right = q.right;
                    q.right = null;
                    p = p.right;
                } else {
                    p = null;
                }
            }
        }
        return root;
    }


    /**
     * 复制一颗二叉树
     *
     * @param root 原二叉树的根节点
     * @return 返回新创建的二叉树
     * 一边遍历，一边创建节点并且连线
     */
    public TreeNode dupblicateBiTree(TreeNode root) {
        if (root != null) {
            TreeNode newRoot = new TreeNode();
            newRoot.val = root.val;
            newRoot.left = dupblicateBiTree(root.left);
            newRoot.right = dupblicateBiTree(root.right);
            return newRoot;
        }
        return null;
    }

    /**
     * 由数组创建一个二插排序树
     * 遍历数组，以第一个元素为根节点，其他元素小于根节点的在根节点左边，大于根节点的在根节点右边
     * 需要辅助指针，每次遍历一个数据的时候需要比较当前指针q的值和当前数据的大小
     * 1 相等(暂时不考虑)
     * 插入左右子树都可以
     * 2 小于
     * 继续和p的左子树比较
     * p = p.left
     * 3 大于
     * 继续和p的右子树比较
     * p = p.right
     * <p>
     * 方法时间复杂度
     * O(nlgn)
     */
    public TreeNode constructSortTree(int[] data) {
        if (data.length == 0) {
            // 传入的数组为空
            return null;
        }
        TreeNode<Integer> root = new TreeNode<>();
        TreeNode<Integer> p = new TreeNode<>();
        root.val = data[0];

        for (int i = 1; i < data.length; i++) {
            // 每插入一个节点都需要遍历已经创建的树
            p = root;
            while (true) {
                if (p.val >= data[i]) {
                    if (p.left != null) {
                        p = p.left;
                    } else {
                        // 如果节点的左子树为空，则将小于当前节点的值置于左子树
                        TreeNode<Integer> node = new TreeNode<>();
                        node.val = data[i];
                        p.left = node;
                        break;
                    }
                } else if (p.val < data[i]) {
                    if (p.val < data[i]) {
                        if (p.right != null) {
                            p = p.right;
                        } else {
                            // 如果节点的右子树为空，则将大于当前节点的值置于右子树
                            TreeNode<Integer> node = new TreeNode<>();
                            node.val = data[i];
                            p.right = node;
                            break;
                        }
                    } else {
                        System.out.println("Equals!");
                    }
                }
            }
        }
        return root;
    }
    /**
     * 将一棵二叉树转化为二插排序树
     *      转化为数组再进行创建
     *      算法时间复杂度：
     *          O(2*n*lgn)
     */
    /**
     * 将一棵二插树转化为严格二叉树
     */


    /**
     * 寻找排序二叉树的的最小值
     * 时间复杂度：
     * O(lgn)
     */
    public int getMinimum(TreeNode<Integer> root) {
        if (root == null) {
            System.out.println("传入的树为空！");
            return -1;
        }
        TreeNode<Integer> tmp = root;
        while (tmp.left != null) {
            tmp = tmp.left;
        }
        return tmp.val;
    }

    /**
     * 寻找排序二叉树的的最大值
     * 时间复杂度：
     * O(lgn)
     */
    public int getMaximum(TreeNode<Integer> root) {
        if (root == null) {
            System.out.println("传入的树为空！");
            return -1;
        }
        TreeNode<Integer> tmp = root;
        while (tmp.right != null) {
            tmp = tmp.right;
        }
        return tmp.val;
    }

    /**
     * 寻找排序二叉树的的最小值
     * 递归版本
     * 时间复杂度：
     * O(lgn)
     */
    public TreeNode getMinimumByRecursion(TreeNode<Integer> root) {
        if (root == null) {
            // 抵达叶子节点或者传入的节点为空节点
            return null;
        } else if (root.left != null) {
            return getMinimumByRecursion(root.left);
        } else {
            return root;
        }
    }


    /**
     * 寻找排序二叉树的的最大值
     * 递归版本
     * 时间复杂度：
     * O(lgn)
     */
    public TreeNode getMaximumByRecursion(TreeNode<Integer> root) {
        if (root == null) {
            // 抵达叶子节点或者传入的节点为空节点
            return null;
        } else if (root.right != null) {
            return getMaximumByRecursion(root.right);
        } else {
            return root;
        }
    }

    /**
     * 返回二叉排序树中指定节点的后继节点
     * 1 当前节点的右子树不为空：
     * 当前节点的后继节点为当前节点右子树的最左节点
     * 2 当前节点的右子树为空
     * 当前节点的后继节点为当存在当前节点的祖先节点为其祖先节点的父节点的左子树时候
     * 的祖先节点的父节点
     *
     * @param root
     * @return 返回后继节点
     */
    public TreeNode<Integer> TREE_SUSSESSOR(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right != null) {
            // 当前节点存在右子树
            return getMinimumByRecursion(root.right);
        } else {
            // 当前节点不存在右子树
            // 初始化建立指针
            TreeNode<Integer> cur = root;
            TreeNode<Integer> parent = cur.parent;
            while (parent != null && cur == parent.right) {
                parent = parent.parent;
                cur = cur.parent;
            }
            // 此时cur为parent的左子树，当查询的节点为树中的最右节点，此时的parent节点为根节点
            return parent;
        }
    }

    /**
     * 返回二叉排序树中指定节点的前继节点
     * 1 当前节点的左子树不为空：
     * 当前节点的后继节点为当前节点右子树的最左节点
     * 2 当前节点的左子树为空
     * 当前节点的前继节点为当存在当前节点的祖先节点为其祖先节点的父节点的右子树时候
     * 的祖先节点的父节点
     *
     * @param root
     * @return 返回后继节点
     */
    public TreeNode<Integer> TREE_PREDECESSOR(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            // 当前节点存在左子树
            return getMaximumByRecursion(root.left);
        } else {
            // 当前节点不存在左子树
            // 初始化建立指针
            TreeNode<Integer> cur = root;
            TreeNode<Integer> parent = cur.parent;
            while (parent != null && cur == parent.left) {
                parent = parent.parent;
                cur = cur.parent;
            }
            // 此时cur为parent的左子树，当查询的节点为树中的最右节点，此时的parent节点为根节点
            return parent;
        }


    }


}
