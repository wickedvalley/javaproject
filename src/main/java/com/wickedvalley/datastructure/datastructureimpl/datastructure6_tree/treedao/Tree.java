package com.wickedvalley.datastructure.datastructureimpl.datastructure6_tree.treedao;

import com.wickedvalley.datastructure.domain.TreeNode;

/**
 * Created by Administrator on 2018/7/7.
 */
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
     * 中序遍历
     * */
    void middleOrder(TreeNode current);

    /**
     * 后续遍历
     * */
    void postOrder(TreeNode current);

    /**
     * 查找最大节点
     * */
    TreeNode findMaxNode();

    /**
     *查找最小节点
     * */
    TreeNode findMinNode();

    /**
     * 删除某个节点
     * */
    void delete(int key);
}
