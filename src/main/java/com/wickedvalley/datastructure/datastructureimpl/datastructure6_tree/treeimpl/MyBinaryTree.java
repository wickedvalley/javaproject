package com.wickedvalley.datastructure.datastructureimpl.datastructure6_tree.treeimpl;

import com.wickedvalley.datastructure.datastructureimpl.datastructure6_tree.treedao.Tree;
import com.wickedvalley.datastructure.domain.TreeNode;

import java.util.*;

/**
 * Created by MinZeng
 * 时间：2018/9/24.
 * 二叉树的常规操作
 */
public class MyBinaryTree implements Tree {

    private TreeNode root;//根节点

    @Override
    public TreeNode find(int key) {
        while (root != null) {
            if (root.getData() > key) {
                root = root.getLeft();
            } else if (root.getData() < key) {
                root = root.getRight();
            } else {
                return root;
            }
        }
        return null;
    }

    @Override
    public boolean insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return true;
        }
        TreeNode parentNode;
        TreeNode current = root;
        TreeNode node = new TreeNode(data);
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

        return false;
    }

    @Override
    public void preOrder(TreeNode current) {
        if (current != null) {
            System.out.print(current.getData() + " ");
            preOrder(current.getLeft());
            preOrder(current.getRight());
        }
    }

    /**
     * 非递归的先序遍历
     */
    @Override
    public void nonRecursionPreOrder(TreeNode current) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (current != null) {
            stack.push(current);
        } else {
            return;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.getData() + " ");
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }

    @Override
    public void middleOrder(TreeNode current) {
        if (current != null) {
            middleOrder(current.getLeft());
            System.out.print(current.getData() + " ");
            middleOrder(current.getRight());
        }
    }

    /**
     * 非递归的中序遍历
     */
    @Override
    public void nonRecursionMiddleOrder(TreeNode current) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (current == null) {
            return;
        }
        while (current != null || stack.size() > 0) {

            //左孩子不为空，进栈
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            if (stack.size() > 0) {
                current = stack.pop();
                System.out.print(current.getData() + " ");
                current = current.getRight();
            }
        }
    }

    @Override
    public void postOrder(TreeNode current) {
        if (current != null) {
            postOrder(current.getLeft());
            postOrder(current.getRight());
            System.out.print(current.getData() + " ");
        }
    }

    /**
     * 非递归的后序遍历
     * 思想：左---右---根
     * 根----左---右   翻转    右---左---根
     * <p>
     * 目标
     * 根----右---左   翻转    左---右---根
     */
    @Override
    public void nonRecursionPostOrder(TreeNode current) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (current != null) {
            stack.push(current);
        } else {
            return;
        }
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            nodeList.add(node);
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
        }
        Collections.reverse(nodeList);
        for (TreeNode node : nodeList) {
            System.out.print(node.getData() + " ");
        }
    }

    @Override
    public TreeNode findMaxNode() {
        TreeNode current = root;
        while (current != null) {
            if (current.getRight() != null) {
                current = current.getRight();
            } else {
                break;
            }
        }
        return current;
    }

    @Override
    public TreeNode findMinNode() {
        TreeNode current = root;
        while (current != null) {
            if (current.getLeft() != null) {
                current = current.getLeft();
            } else {
                break;
            }
        }
        return current;
    }

    @Override
    public int treeDepth(TreeNode root) {
        int left = root.getLeft() == null ? 0 : treeDepth(root.getLeft());
        int right = root.getRight() == null ? 0 : treeDepth(root.getRight());

        return Math.max(left, right) + 1;
    }

    @Override
    public void reverseTree(TreeNode root) {
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

    @Override
    public void levelPrintTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.add(root);
        } else {
            return;
        }

        int current = 1;
        int next = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            current--;
            System.out.print(node.getData() + " ");
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
        MyBinaryTree tree = new MyBinaryTree();
        tree.insert(50);
        tree.insert(20);
        tree.insert(80);
        tree.insert(10);

//        System.out.print("递归的先序遍历:");
//        tree.preOrder(tree.root);
//
//        System.out.print("非递归的先序遍历:");
//        tree.nonRecursionPreOrder(tree.root);


//
        System.out.print("递归的中序遍历:");
        tree.middleOrder(tree.root);

        System.out.print("非递归的中序遍历:");
        tree.nonRecursionMiddleOrder(tree.root);
//
//        System.out.print("递归的后序遍历:");
//        tree.postOrder(tree.root);
//
//        System.out.print("非递归的后序遍历:");
//        tree.nonRecursionPostOrder(tree.root);

        //查询最大节点
//        System.out.println(tree.findMaxNode().getData());
//
//        //查询最小节点
//        System.out.println(tree.findMinNode().getData());
//
        //求树的深度
//        System.out.println(tree.treeDepth(tree.root));

        //翻转树
//        tree.reverseTree(tree.root);

//        tree.levelPrintTree(tree.root);


    }
}
