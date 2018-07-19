package com.wickedvalley.datastructure.domain;

import lombok.Data;
import lombok.ToString;

/**
 * Created by Administrator on 2018/7/5.
 * 二叉树的节点设置
 */
@Data
@ToString(callSuper = false)
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


}
