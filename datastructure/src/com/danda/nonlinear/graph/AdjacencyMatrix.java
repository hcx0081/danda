package com.danda.nonlinear.graph;

import java.util.LinkedList;

/**
 * {@code @Description:} 邻接矩阵
 */
public class AdjacencyMatrix {
    // 顶点表
    String[] vertex;
    // 邻接矩阵
    Integer[][] matrix;
    
    // 访问标志数组
    boolean[] visited;
    
    /**
     * @param n 顶点个数
     */
    public AdjacencyMatrix(int n) {
        this.vertex = new String[n];
        this.matrix = new Integer[n][n];
        
        this.visited = new boolean[n];
    }
    
    /**
     * 创建无向图
     *
     * @param v 顶点
     * @param m 两个顶点及其连接的边的权值
     */
    public void createUndirectedGraph(String[] v, String[] m) {
        // 初始化顶点数组
        System.arraycopy(v, 0, vertex, 0, vertex.length);
        
        // 初始化邻接矩阵
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = 0;
            }
        }
        
        // 根据顶点的关系和权值给邻接矩阵赋值
        for (String str : m) {
            String[] strings = str.split(",");
            
            // 顶点v1
            String v1 = strings[0];
            // 顶点v2
            String v2 = strings[1];
            // 获取索引下标
            int i = locateVertex(v1);
            int j = locateVertex(v2);
            
            // 根据无向图的对称性
            this.matrix[i][j] = 1;
            this.matrix[j][i] = 1;
        }
    }
    
    // 查找指定顶点在顶点数组中的索引下标
    private int locateVertex(String v) {
        for (int i = 0; i < this.vertex.length; i++) {
            if (this.vertex[i].equals(v)) {
                return i;
            }
        }
        return -1;
    }
    
    // 打印邻接矩阵
    public void printAdjacencyMatrix() {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix.length; j++) {
                System.out.print(this.matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    /**
     * 深度优先遍历
     *
     * @param i 从第几个顶点开始遍历
     */
    public void depthFirstSearch(int i) {
        // 访问结点
        System.out.print(this.vertex[i] + " ");
        this.visited[i] = true;
        int j;
        for (j = 0; j < this.vertex.length; j++) {
            // 如果两个顶点相连，并且未被访问
            if (this.matrix[i][j] == 1 && !visited[j])
                depthFirstSearch(j);
        }
    }
    
    /**
     * 广度优先遍历
     *
     * @param i 从第几个顶点开始遍历
     */
    public void breadthFirstSearch(int i) {
        // 访问结点
        System.out.print(this.vertex[i] + " ");
        this.visited[i] = true;
        
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(i);
        
        while (!queue.isEmpty()) {
            i = queue.poll();
            
            // 获取顶点的第一个邻接点
            for (int j = 0; j < this.vertex.length; j++) {
                // 如果两个顶点相连，并且未被访问
                if (this.matrix[i][j] == 1 && !visited[j]) {
                    System.out.print(this.vertex[j] + " ");
                    this.visited[j] = true;
                    
                    queue.add(j);
                }
            }
        }
    }
}