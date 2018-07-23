package com.wickedvalley.datastructure.datastructureimpl.datastructure6_tree.treeimpl;

import com.wickedvalley.datastructure.datastructureimpl.datastructure6_tree.treedao.Tree;
import com.wickedvalley.datastructure.domain.TreeNode;
import org.omg.CORBA.TRANSACTION_MODE;

import java.util.*;

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
     * 非递归先序遍历
     */
    @Override
    public void nonRecursionPreOrder(TreeNode current) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode;
        stack.push(current);
        while (!stack.isEmpty()) {
            treeNode = stack.pop();
            System.out.println(treeNode.getData());
            if (treeNode.getRight() != null) {
                stack.push(treeNode.getRight());
            }
            if (treeNode.getLeft() != null) {
                stack.push(treeNode.getLeft());
            }
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
     * 非递归中序遍历
     */
    @Override
    public void nonRecursionMiddleOrder(TreeNode current) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = current;
        while (treeNode != null || stack.size() > 0) {
            //存在左子树
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.getLeft();
            }
            //栈不为空
            if (stack.size() > 0) {
                treeNode = stack.pop();
                System.out.println(treeNode.getData());
                treeNode = treeNode.getRight();
            }
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
     * 非递归后续遍历
     * 思想：
     * 1.先序遍历是：根-->左-->右
     * 2.后续遍历是：左-->右-->根
     * 则后续遍历是：根-->右-->左，然后再翻转即可
     */
    @Override
    public void nonRecursionPostOrder(TreeNode current) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode;
        stack.push(current);

        //根-->右-->左 遍历
        while (!stack.isEmpty()) {
            treeNode = stack.pop();
            list.add(treeNode.getData());
            if (treeNode.getLeft()!=null){
                stack.add(treeNode.getLeft());
            }
            if (treeNode.getRight()!=null){
                stack.add(treeNode.getRight());
            }
        }
        Collections.reverse(list);
        System.out.println(list);
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
     * 层次遍历二叉树
     */
    @Override
    public void levelPrintTree(TreeNode root) {
        if (root == null) {
            System.out.println("root节点为空");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int current = 1;//当前层节点的数量
        int next = 0;//下一层的节点数量
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            current--;
            System.out.println(node.getData());
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
                next++;
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
                next++;
            }
            if (current == 0) {
                current = next;
                next = 0;
            }
        }
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

        //非递归先序遍历
        System.out.println("非递归先序遍历");
        bt.nonRecursionPreOrder(bt.root);

        //中序遍历
        System.out.println("中序遍历");
        bt.middleOrder(bt.root);

        //非递归中序遍历
        System.out.println("非递归中序遍历");
        bt.nonRecursionMiddleOrder(bt.root);

        //后序遍历
        System.out.println("后序遍历");
        bt.postOrder(bt.root);

        //非递归后序遍历
        System.out.println("非递归后序遍历");
        bt.nonRecursionPostOrder(bt.root);

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

        //层次遍历二叉树
        System.out.println("层次遍历二叉树");
        bt.levelPrintTree(bt.root);

        //翻转二叉树
        bt.reverseTree(bt.root);


    }
}
