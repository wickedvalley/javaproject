package com.wickedvalley.datastructure.datastructureimpl.datastructure7_graph;

/**
 * Created by MinZeng
 * 时间：2018/9/25.
 */
public class Vertexs {
    char node;//顶点
    boolean isVisited;//记录是否已经访问过了

    public Vertexs(char node) {
        this.node = node;
        this.isVisited = false;
    }
}