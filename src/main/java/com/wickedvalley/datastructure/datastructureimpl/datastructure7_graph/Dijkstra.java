package com.wickedvalley.datastructure.datastructureimpl.datastructure7_graph;

/**
 * Created by MinZeng
 * 时间：2018/5/9
 * 图见本项目的graph
 */
public class Dijkstra {

    static int M=1000000;//(此路不通)
    public static void main(String[] args) {

        int[][] weight = {
                {0,10,M,30,100},
                {M,0,50,M,M},
                {M,M,0,M,10},
                {M,M,20,0,60},
                {M,M,M,M,0}
        };
        int start=0;
        int[] shortPath = Dijsktra(weight,start);//返回的是最短距离

        for(int i = 0;i < shortPath.length;i++)
            System.out.println("从"+start+"出发到"+i+"的最短距离为："+shortPath[i]);

    }


    public static int[] Dijsktra(int[][] weight,int start){
        //接受一个有向图的权重矩阵，和一个起点编号start（从0编号，顶点存在数组中）
        //返回一个int[] 数组，表示从start到它的最短路径长度
        int n = weight.length;        //顶点个数
        int[] shortPath = new int[n];    //存放从start到其他各点的最短路径距离
        String[] path=new String[n]; //存放从start到其他各点的最短路径的字符串表示
        for(int i=0;i<n;i++)
            path[i]=new String(start+"-->"+i);
        int[] visited = new int[n];   //标记当前该顶点的最短路径是否已经求出,1表示已求出

        //初始化，第一个顶点求出
        shortPath[start] = 0;
        visited[start] = 1;//第一个顶点的最短路径已经求出

        for(int count = 1;count <= n - 1;count++)  //要加入n-1个顶点
        {

            int k = -1;    //选出一个距离初始顶点start最近的未标记顶点
            int dmin = Integer.MAX_VALUE;

            for(int i = 0;i < n;i++)
            {
                if(visited[i] == 0 && weight[start][i] < dmin)
                {
                    dmin = weight[start][i];

                    k = i;//与start距离最近的且未被标记的顶点
                }

            }
            System.out.println("k="+k);

            //将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dmin
            shortPath[k] = dmin;

            visited[k] = 1;

            //以k为中间点，修正从start到未访问各点的距离
            for(int i = 0;i < n;i++)
            {
                if(visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]){
                    weight[start][i] = weight[start][k] + weight[k][i];//修正从当前顶点到其他未访问顶点的距离

                    path[i]=path[k]+"-->"+i;//有中间点k过度

                }

            }

        }
        for(int i=0;i<n;i++)
            System.out.println("从"+start+"出发到"+i+"的最短路径为："+path[i]);
        System.out.println("=====================================");

        return shortPath;
    }

}
