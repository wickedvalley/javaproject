package com.wickedvalley.datastructure.datastructureimpl.datastructure6_tree.treeimpl;

import com.wickedvalley.datastructure.datastructureimpl.datastructure6_tree.treedao.Tree;
import com.wickedvalley.datastructure.domain.TreeNode;

/**
 * Created by Administrator on 2018/7/7.
 */
public class BinaryTree implements Tree {

    //root节点
    private TreeNode root;

    public TreeNode find(int key) {
        return null;
    }

    /**
     *
     * 插入节点
     *
     * */
    public boolean insert(int data) {
        TreeNode node = new TreeNode(data);
        if (root == null) {//根节点为空
            root=node;
            return true;
        }else {
            TreeNode parentNode = null;
            TreeNode current = root;
            while (current!=null){
                parentNode = current;
                if(current.getData()>data){

                }
            }
        }
        return false;
    }

    public void preOrder(TreeNode current) {

    }

    public void middleOrder(TreeNode current) {

    }

    public void postOrder(TreeNode current) {

    }

    public TreeNode findMaxNode() {
        return null;
    }

    public TreeNode findMinNode() {
        return null;
    }

    public void delete(int key) {

    }

    public static void main(String[] args) {

    }
}
