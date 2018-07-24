package com.wickedvalley.datastructure.datastructureimpl.datastructure6_tree.treedao;

import com.wickedvalley.datastructure.domain.TreeNode;

public interface Tree {

    /**
     * 查找节点
     * */
    TreeNode find(int key);

    /**
     * 插入节点
     * */
    boolean insert(int data);

    /**
     * 先序遍历
     * */
    void preOrder(TreeNode current);

    /**
     * 非递归先序遍历
     * 说明：该遍历也属于深度优先遍历
     * */
    void nonRecursionPreOrder(TreeNode current);

    /**
     * 中序遍历
     * */
    void middleOrder(TreeNode current);

    /**
     * 非递归中序遍历
     * */
    void nonRecursionMiddleOrder(TreeNode current);

    /**
     * 后续遍历
     * */
    void postOrder(TreeNode current);

    /**
     * 非递归后续遍历
     * */
    void nonRecursionPostOrder(TreeNode current);

    /**
     * 查找最大节点
     * */
    TreeNode findMaxNode();

    /**
     *查找最小节点
     * */
    TreeNode findMinNode();

    /**
     *求深度
     * */
    int treeDepth(TreeNode root);

    /**
     *翻转二叉树
     * */
    void reverseTree(TreeNode root);

    /**
     *层次遍历二叉树
     * */
    void levelPrintTree(TreeNode root);

}
