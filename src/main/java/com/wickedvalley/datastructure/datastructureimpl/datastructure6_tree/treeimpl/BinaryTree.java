package com.wickedvalley.datastructure.datastructureimpl.datastructure6_tree.treeimpl;

import com.wickedvalley.datastructure.datastructureimpl.datastructure6_tree.treedao.Tree;
import com.wickedvalley.datastructure.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree implements Tree {

    //root节点
    private TreeNode root;

    /**
     * 查找节点
     */
    @Override
    public TreeNode find(int key) {
        TreeNode current = root;
        while (current != null) {
            if (current.getData() > key) {
                current = current.getLeft();
            } else if (current.getData() < key) {
                current = current.getRight();
            } else {
                return current;
            }
        }
        return null;
    }

    /**
     * 插入节点
     */
    @Override
    public boolean insert(int data) {
        TreeNode node = new TreeNode(data);
        if (root == null) {//根节点为空
            root = node;
            return true;
        } else {
            TreeNode parentNode = null;
            TreeNode current = root;
            while (current != null) {
                parentNode = current;
                if (current.getData() > data) {
                    current = current.getLeft();
                    if (current == null) {
                        parentNode.setLeft(node);
                        return true;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        parentNode.setRight(node);
                        return true;
                    }

                }
            }
        }
        return false;
    }

    /**
     * 先序遍历
     */
    @Override
    public void preOrder(TreeNode current) {
        if (current != null) {
            System.out.println(current.getData());
            preOrder(current.getLeft());
            preOrder(current.getRight());
        }
    }

    /**
     * 中序遍历
     */
    @Override
    public void middleOrder(TreeNode current) {
        if (current != null) {
            middleOrder(current.getLeft());
            System.out.println(current.getData());
            middleOrder(current.getRight());
        }

    }

    /**
     * 后序遍历
     */
    @Override
    public void postOrder(TreeNode current) {
        if (current != null) {
            middleOrder(current.getLeft());
            middleOrder(current.getRight());
            System.out.println(current.getData());
        }
    }

    /**
     * 查找最大值得节点
     */
    @Override
    public TreeNode findMaxNode() {
        TreeNode current = root;
        TreeNode maxNode = current;
        while (current != null) {
            maxNode = current;
            current = current.getRight();
        }
        return maxNode;
    }

    /**
     * 查找最小值得节点
     */
    @Override
    public TreeNode findMinNode() {
        TreeNode current = root;
        TreeNode minNode = current;
        while (current != null) {
            minNode = current;
            current = current.getLeft();
        }
        return minNode;
    }

    /**
     * 求深度
     */
    @Override
    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = root.getLeft() == null ? 0 : treeDepth(root.getLeft());
        int right = root.getRight() == null ? 0 : treeDepth(root.getRight());
        return Math.max(left, right) + 1;
    }

    /**
     * 翻转二叉树
     */
    @Override
    public void reverseTree(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.getLeft() != null) {
            reverseTree(root.getLeft());
        }
        if (root.getRight() != null) {
            reverseTree(root.getRight());
        }
        TreeNode temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);

    }

    /**
     * 翻转二叉树
     */
    @Override
    public void levelPrintTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();


    }

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);

        //先序遍历
        System.out.println("先序遍历");
        bt.preOrder(bt.root);

        //中序遍历
        System.out.println("中序遍历");
        bt.middleOrder(bt.root);

        //后序遍历
        System.out.println("后序遍历");
        bt.postOrder(bt.root);

        //查找最大节点
        TreeNode maxNode = bt.findMaxNode();
        System.out.println("最大节点信息：" + maxNode.toString());

        //查找最小节点
        TreeNode minNode = bt.findMinNode();
        System.out.println("最小节点信息：" + minNode.toString());

        //查找指定的节点
        TreeNode result = bt.find(80);
        System.out.println("查找的节点结果：" + result);

        //求深度
        System.out.println(bt.treeDepth(bt.root));

        //翻转二叉树
        bt.reverseTree(bt.root);
    }
}
