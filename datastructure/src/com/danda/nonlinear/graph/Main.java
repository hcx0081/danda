package com.danda.nonlinear.graph;

/**
 * {@code @Description:}
 */
public class Main {
    public static void main(String[] args) {
        AdjacencyMatrix matrix = new AdjacencyMatrix(5);
        matrix.createUndirectedGraph(new String[]{"A", "B", "C", "D", "E"},
                new String[]{"A,B", "A,D", "B,C", "C,D", "B,E", "C,E"});
        matrix.printAdjacencyMatrix();
        matrix.breadthFirstSearch(0);
        
        // AdjacencyTable table = new AdjacencyTable(5);
        // table.createUndirectedGraph(new String[]{"A", "B", "C", "D", "E"},
        //         new String[]{"A,B", "A,D", "B,C", "C,D", "B,E", "C,E"});
        // table.printAdjacencyTable();
        // table.breadthFirstSearch(1);
    }
}