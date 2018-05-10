package com.main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by MinZeng
 * 时间：2018/5/7.
 */
public class Graphs {

    /**
     * 顶点的定义
     * */
    class Vertex {
        public char v;//顶点
        public boolean isVisited;//记录是否访问过

        public Vertex(char v) {
            this.v = v;
            this.isVisited = false;
        }
    }

    public static final int MAX_VERTICS=20;   //最多的顶点数
    //图的组成：顶点和边
    public Vertex [] verticesList;           //顶点
    public int [][]edges;                    //存储边
    int verticsNum=0;
    Stack<Integer> stack=null;
    Queue<Integer> queue=null;


    //图的创建
    public Graphs() {
        verticesList = new Vertex[MAX_VERTICS];//顶点数

        edges= new int[MAX_VERTICS][MAX_VERTICS];
        for(int i=0;i<MAX_VERTICS;i++){//边的初始化
            for(int j=0;j<MAX_VERTICS;j++){
                edges[i][j]=0;
            }
        }
        stack = new Stack<Integer>();
        queue = new LinkedList<Integer>();
    }

    //添加顶点
    public void addVertics(char v){
        verticesList[verticsNum++]=new Vertex(v);
    }

    //添加边
    public void addEdge(int start,int end){
        edges[start][end]=1;
        edges[end][start]=1;
    }

    //打印顶点信息
    public void show(int i){
        System.out.print(verticesList[i].v+" ");
    }


    //深度优先遍历
    public void dfs(){
        System.out.print("深度优先遍历：");
        show(0);
        verticesList[0].isVisited=true;
        stack.push(0);//第一个节点入栈

        while (!stack.isEmpty()){
            int v=stack.peek();//获得当前的顶点
            int j=getUnvisitedVertics(v);//获得与当前节点v相连的点j
            if(j==-1){//没有与当前节点相连且未被访问
                stack.pop();
            }else {//继续访问
                stack.push(j);//第j个节点入栈
                show(j);
                verticesList[j].isVisited=true;
            }
        }
        for(int i=0;i<verticsNum;i++){//访问完毕，所有节点恢复状态
            verticesList[i].isVisited=false;
        }
    }


    //广度优先遍历
    public void bfs(){
        System.out.println();
        System.out.print("广度优先遍历：");
        show(0);
        verticesList[0].isVisited=true;
        queue.add(0);
        while (!queue.isEmpty()){
            int v=queue.poll();//当前顶点
            for(int j=0;j<verticsNum;j++){
                if(edges[v][j]==1&&verticesList[j].isVisited==false){//访问与当前顶点相连且未被访问的顶点
                    show(j);
                    queue.add(j);
                    verticesList[j].isVisited=true;
                }
            }
        }
        for(int i=0;i<verticsNum;i++){//访问完毕，所有节点恢复状态
            verticesList[i].isVisited=false;
        }


    }


    //获得与当前节点v相连，且未被访问的节点
    public int getUnvisitedVertics(int v){
        for(int j=0;j<verticsNum;j++){
            if(edges[v][j]==1&&verticesList[j].isVisited==false){
                return j;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        Graphs graphs = new Graphs();
        graphs.addVertics('A');
        graphs.addVertics('B');
        graphs.addVertics('C');
        graphs.addVertics('D');
        graphs.addVertics('E');

        graphs.addEdge(0,1);//AB
        graphs.addEdge(1,2);//BC
        graphs.addEdge(0,3);//AD
        graphs.addEdge(3,4);//DE

        graphs.dfs();

        graphs.bfs();


    }

}
