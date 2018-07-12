package com.wickedvalley.datastructure.domain;

/**
 * Created by Administrator on 2018/7/5.
 * 二叉树的节点设置
 */
public class TreeNode {
    private Integer data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    /**
     * 显示内容
     * */
    public void display(){
        System.out.println("show:"+this.data);
    }


    public TreeNode(Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
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
