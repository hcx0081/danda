package com.danda.nonlinear.graph;

import java.util.LinkedList;

/**
 * {@code @Description:} 邻接表
 */
public class AdjacencyTable {
    // 表头结点数组
    TableHeadNode[] tableHeadNodeArr;
    
    // 访问标志数组
    boolean[] visited;
    
    /**
     * @param n 顶点个数
     */
    public AdjacencyTable(int n) {
        this.tableHeadNodeArr = new TableHeadNode[n];
        
        this.visited = new boolean[n];
    }
    
    /**
     * 创建无向图
     *
     * @param v 顶点
     * @param m 两个顶点
     */
    public void createUndirectedGraph(String[] v, String[] m) {
        // 初始化表头结点数组
        for (int i = 0; i < this.tableHeadNodeArr.length; i++) {
            this.tableHeadNodeArr[i] = new TableHeadNode(v[i], null);
        }
        
        // 根据顶点的关系和权值初始化链表
        for (String str : m) {
            String[] strings = str.split(",");
            
            // 表头结点1
            String v1 = strings[0];
            // 表头结点2
            String v2 = strings[1];
            
            // 获取两个表头结点在表头结点数组中的索引下标
            int i = locateVertex(v1);
            int j = locateVertex(v2);
            
            if (this.tableHeadNodeArr[i].firstAdj == null) {
                this.tableHeadNodeArr[i].firstAdj = new EdgeNode(j, null);
            } else {
                EdgeNode edgeNode = this.tableHeadNodeArr[i].firstAdj;
                while (edgeNode.nextAdj != null) {
                    edgeNode = edgeNode.nextAdj;
                }
                edgeNode.nextAdj = new EdgeNode(j, null);
                
            }
            
            if (this.tableHeadNodeArr[j].firstAdj == null) {
                this.tableHeadNodeArr[j].firstAdj = new EdgeNode(i, null);
            } else {
                EdgeNode edgeNode = this.tableHeadNodeArr[j].firstAdj;
                while (edgeNode.nextAdj != null) {
                    edgeNode = edgeNode.nextAdj;
                }
                edgeNode.nextAdj = new EdgeNode(i, null);
            }
        }
    }
    
    // 查找指定顶点在表头结点数组中的索引下标
    private int locateVertex(String v) {
        for (int i = 0; i < this.tableHeadNodeArr.length; i++) {
            if (this.tableHeadNodeArr[i].data.equals(v)) {
                return i;
            }
        }
        return -1;
    }
    
    // 打印邻接表
    public void printAdjacencyTable() {
        for (int i = 0; i < this.tableHeadNodeArr.length; i++) {
            System.out.print(this.tableHeadNodeArr[i].data + "\t");
            
            EdgeNode edgeNode = this.tableHeadNodeArr[i].firstAdj;
            while (edgeNode != null) {
                System.out.print(edgeNode.adjIndex + "\t");
                edgeNode = edgeNode.nextAdj;
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
        System.out.print(this.tableHeadNodeArr[i].data + " ");
        this.visited[i] = true;
        
        // 获取顶点的第一个邻接点
        EdgeNode edgeNode = this.tableHeadNodeArr[i].firstAdj;
        while (edgeNode != null) {
            // 如果顶点未被访问
            if (!visited[edgeNode.adjIndex]) {
                depthFirstSearch(edgeNode.adjIndex);
            }
            edgeNode = edgeNode.nextAdj;
        }
    }
    
    /**
     * 广度优先遍历
     *
     * @param i 从第几个顶点开始遍历
     */
    public void breadthFirstSearch(int i) {
        // 访问结点
        System.out.print(this.tableHeadNodeArr[i].data + " ");
        this.visited[i] = true;
        
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(i);
        
        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            
            // 获取顶点的第一个邻接点
            EdgeNode edgeNode = this.tableHeadNodeArr[index].firstAdj;
            while (edgeNode != null) {
                // 如果顶点未被访问
                if (!visited[edgeNode.adjIndex]) {
                    
                    System.out.print(this.tableHeadNodeArr[edgeNode.adjIndex].data + " ");
                    this.visited[edgeNode.adjIndex] = true;
                    
                    queue.add(edgeNode.adjIndex);
                }
                edgeNode = edgeNode.nextAdj;
            }
        }
    }
    
    // 表头结点
    class TableHeadNode {
        String data;
        EdgeNode firstAdj;
        
        public TableHeadNode(String data, EdgeNode firstAdj) {
            this.data = data;
            this.firstAdj = firstAdj;
        }
    }
    
    // 边结点
    class EdgeNode {
        int adjIndex;
        EdgeNode nextAdj;
        
        public EdgeNode(int adjIndex, EdgeNode nextAdj) {
            this.adjIndex = adjIndex;
            this.nextAdj = nextAdj;
        }
    }
}