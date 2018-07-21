package com.wickedvalley.datastructure.domain;

public class Vertex {

    /**
     * 图的顶点定义
     */
    public char v;//顶点
    public boolean isVisited;//记录是否访问过

    public Vertex(char v) {
        this.v = v;
        this.isVisited = false;
    }

}
