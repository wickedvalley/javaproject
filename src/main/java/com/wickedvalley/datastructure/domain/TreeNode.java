package com.wickedvalley.datastructure.domain;

/**
 * Created by Administrator on 2018/7/5.
 * 二叉树的节点设置
 */
public class TreeNode {
    private Integer value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
