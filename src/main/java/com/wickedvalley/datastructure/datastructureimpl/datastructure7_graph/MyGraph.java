package com.wickedvalley.datastructure.datastructureimpl.datastructure7_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by MinZeng
 * 时间：2018/9/25.
 */
public class MyGraph {

    private Vertexs[] vertexsList;//存放的顶点数；
    private int[][] edge;  //存放边信息
    private int currentNumbers;
    private int DEFAULT = 20;//缺省的数据大小
    private int MAX_VALUE = 50;
    private int index = 0;

    public MyGraph(int initNumber) {//图的初始化
        edge = new int[initNumber][initNumber];
        vertexsList = new Vertexs[initNumber];
    }

    private void addVertics(char node) {
        Vertexs vertexs = new Vertexs(node);
        vertexsList[index++] = vertexs;
        currentNumbers++;
    }

    private void addEdge(int start, int end) {
        edge[start][end] = 1;
    }

    //打印邻接矩阵
    private void printEdge() {
        for (int i = 0; i < edge.length; i++) {
            for (int j = 0; j < edge[0].length; j++) {
                System.out.print(edge[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 图的广度优先遍历
     * 队列实现
     */
    private void bfs() {
        Queue<Vertexs> queue = new LinkedList<Vertexs>();
        Vertexs vertexs = vertexsList[0];
        visit(vertexs);
        queue.add(vertexs);
        while (!queue.isEmpty()) {
            Vertexs current = queue.poll();//当前节点
            for (int i = 0; i < vertexsList.length; i++) {//获得与node相连，但是没有访问的节点，入栈
                if (vertexsList[i].node == current.node) {
                    for (int j = 0; j < edge.length; j++) {
                        if (edge[i][j] == 1 && vertexsList[j].isVisited == false) {
                            queue.add(vertexsList[j]);
                            visit(vertexsList[j]);//遍历节点
                        }
                    }
                }
            }

        }


    }

    /**
     * 图的深度优先遍历
     * 队列实现
     */
    private void dfs() {
        Stack<Vertexs> queue = new Stack<Vertexs>();
        Vertexs vertexs = vertexsList[0];
        visit(vertexs);
        queue.push(vertexs);
        while (!queue.isEmpty()) {
            Vertexs current = queue.peek();//当前节点
            int index =-1 ;
            for (int i = 0; i < vertexsList.length; i++) {//获得与node相连，但是没有访问的节点，入栈
                if (vertexsList[i].node == current.node) {
                    for (int j = 0; j < edge.length; j++) {
                        if (edge[i][j] == 1 && vertexsList[j].isVisited == false) {
                            visit(vertexsList[j]);//遍历节点
                            index=j;
                            break;
                        }
                    }
                }
            }
            if (index!=-1){
                queue.push(vertexsList[index]);
            }else {
                queue.pop();
            }

        }


    }


    private void visit(Vertexs vertexs) {
        System.out.println(vertexs.node);
        vertexs.isVisited = true;
    }

    public static void main(String[] args) {
        MyGraph graphs = new MyGraph(5);
        graphs.addVertics('A');
        graphs.addVertics('B');
        graphs.addVertics('C');
        graphs.addVertics('D');
        graphs.addVertics('E');

        graphs.addEdge(0, 1);//AB
        graphs.addEdge(1, 2);//BC
        graphs.addEdge(0, 3);//AD
        graphs.addEdge(3, 4);//DE

//        graphs.printEdge();
//
//        graphs.bfs();

        graphs.dfs();


    }


}
