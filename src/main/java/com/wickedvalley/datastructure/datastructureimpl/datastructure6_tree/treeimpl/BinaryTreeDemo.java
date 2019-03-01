package com.wickedvalley.datastructure.datastructureimpl.datastructure6_tree.treeimpl;

import com.wickedvalley.datastructure.datastructureimpl.datastructure6_tree.treedao.Tree;
import com.wickedvalley.datastructure.domain.TreeNode;

import java.util.*;

public class BinaryTreeDemo implements Tree {

    //根节点
    private TreeNode root;

    @Override
    public TreeNode find(int key) {
        TreeNode current  = root;
        while (current!=null){
            if (current.getData()>key){
                current = current.getLeft();
            }else if (current.getData()<key){
                current = current.getRight();
            }else {
                return current;
            }
        }
        return null;
    }

    @Override
    public boolean insert(int data) {
        if(root == null){
            root = new TreeNode(data);
            return true;
        }
        //二查排序树
        TreeNode parent;
        TreeNode current  =root;
        TreeNode node  = new TreeNode(data);
        while (current!=null){
            parent = current;
            if (current.getData()>data){
                current = current.getLeft();
                if (current == null){
                    parent.setLeft(node);
                    return true;
                }
            }else{
                current =current.getRight();
                if(current == null){
                    parent.setRight(node);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void preOrder(TreeNode current) {
        if (current != null){
            System.out.print(current.getData()+" ");
            preOrder(current.getLeft());
            preOrder(current.getRight());
        }
    }

    //非递归的先序遍历
    @Override
    public void nonRecursionPreOrder(TreeNode current) {
        if (current == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node;
        stack.push(current);
        while (!stack.isEmpty()){
            node = stack.pop();
            System.out.print(node.getData()+" ");
            if (node.getRight()!=null){
                stack.push(node.getRight());
            }
            if (node.getLeft()!=null){
                stack.push(node.getLeft());
            }
        }

    }

    @Override
    public void middleOrder(TreeNode current) {
        if (current != null){
            middleOrder(current.getLeft());
            System.out.print(current.getData()+" ");
            middleOrder(current.getRight());
        }
    }

    @Override
    public void nonRecursionMiddleOrder(TreeNode current) {
        if (current == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (stack.size()>0 || current !=null){
            //左孩子不为空，进栈
            while (current!=null){
                stack.push(current);
                current = current.getLeft();
            }
            if (stack.size()>0){
                current = stack.pop();
                System.out.print(current.getData()+" ");
                current = current.getRight();
            }
        }
    }

    @Override
    public void postOrder(TreeNode current) {
        if (current != null){
            postOrder(current.getLeft());
            postOrder(current.getRight());
            System.out.print(current.getData()+" ");
        }
    }

    //左、右、根
    //根、右、左-->反转
    @Override
    public void nonRecursionPostOrder(TreeNode current) {
        if (current == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(current);
        List<Integer> originData = new ArrayList<Integer>();
        while (stack.size()>0){
            TreeNode node = stack.pop();
            originData.add(node.getData());
            if (node.getLeft()!=null){
                stack.push(node.getLeft());
            }
            if (node.getRight()!=null){
                stack.push(node.getRight());
            }
        }

        Collections.reverse(originData);
        for(Integer node : originData){
            System.out.print(node+" ");
        }


    }

    @Override
    public TreeNode findMaxNode() {
        if (root == null){
            return null;
        }
        TreeNode current  = root;
        TreeNode maxNode = root;
        while (current!=null){
            if (current.getRight()!=null){
                current = current.getRight();
                if (current.getData()>maxNode.getData()){
                    maxNode = current;
                }
            }else {
                break;
            }
        }
        return maxNode;
    }

    @Override
    public TreeNode findMinNode() {
        if (root == null){
            return null;
        }
        TreeNode current  = root;
        TreeNode minNode = root;
        while (current!=null){
            if (current.getLeft()!=null){
                current = current.getLeft();
                if (current.getData()<minNode.getData()){
                    minNode = current;
                }
            }else {
                break;
            }
        }
        return minNode;
    }

    @Override
    public int treeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = root.getLeft() == null ? 0 : treeDepth(root.getLeft());
        int rightDepth = root.getRight() == null ? 0 : treeDepth(root.getRight());
        return Math.max(leftDepth,rightDepth)+1;
    }

    @Override
    public void reverseTree(TreeNode root) {
        if (root == null){
            return;
        }
        if (root.getLeft() != null){
            reverseTree(root.getLeft());
        }
        if (root.getRight() !=null){
            reverseTree(root.getRight());
        }

        TreeNode temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
    }

    @Override
    public void levelPrintTree(TreeNode root) {

        if (root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int current = 1;
        int next =0;

        while (!queue.isEmpty()){
            TreeNode node  = queue.peek();
            System.out.println(node.getData());
            queue.remove();
            current--;
            if (node.getLeft()!=null){
                queue.add(node.getLeft());
                next++;
            }
            if (node.getRight()!=null){
                queue.add(node.getRight());
                next++;
            }
            if (current == 0){
                next = current;
                current = 0;
            }
        }
    }

    public static void main(String[] args) {

        BinaryTreeDemo root = new BinaryTreeDemo();

        //1、插入数据，以二叉排序树法构建树
        root.insert(50);
        root.insert(20);
        root.insert(80);
        root.insert(10);

        //2、先序遍历
        System.out.print("先序遍历：");
        root.preOrder(root.root);

        //3、中序遍历
        System.out.print("中序遍历：");
        root.middleOrder(root.root);

        //4、后序遍历
        System.out.print("后序遍历：");
        root.postOrder(root.root);

        //5、查询节点值为50的节点信息
        System.out.println("节点查询："+root.find(50).toString());

        //6、查找最大节点
        System.out.println("查找最大的节点："+root.findMaxNode().getData());

        //7、查找最小的节点
        System.out.println("查找最小的节点："+root.findMinNode().getData());

        //8、二叉树的高度
        System.out.println(root.treeDepth(root.root));

        //9、层次遍历二叉树
        System.out.println("层次遍历二叉树：");
        root.levelPrintTree(root.root);

        //10、非递归的先序遍历
        System.out.println("非递归的先序遍历：");
        root.nonRecursionPreOrder(root.root);

        //11、非递归的中序遍历
        System.out.println("非递归的中序遍历：");
        root.nonRecursionMiddleOrder(root.root);

        //12、非递归的后序遍历
        System.out.println();
        System.out.println("非递归的后序遍历：");
        root.nonRecursionPostOrder(root.root);


    }
}
