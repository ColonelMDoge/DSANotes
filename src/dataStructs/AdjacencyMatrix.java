package dataStructs;

import java.util.ArrayList;

/*
An adjacency matrix is a data structure used to show the connections between different nodes in a graph
It uses a 2D-array to represent each edge
A connection is represented as a 1 and no connection is a 0
The constructor represents how many unique nodes exist
Each row represents the referenced node
Each column represents the edge connection

Time complexity:
The time complexity to check an edge connection is O(1)

Space complexity:
Because the matrix uses a 2D-array, it uses O(n^2) space where n is each node
 */
public class AdjacencyMatrix implements Graph {
    public int[][] matrix;
    public ArrayList<Node> nodes = new ArrayList<>();
    boolean directed;
    public AdjacencyMatrix(int size, boolean directed) {
        matrix = new int[size][size];
        this.directed = directed;
    }
    @Override
    public void addNode(Node node) {
        nodes.add(node);
    }

    @Override
    public void addEdge(int from, int to) {
        if (directed) matrix[from][to] = 1;
        else {
            matrix[from][to] = 1;
            matrix[to][from] = 1;
        }
    }

    @Override
    public boolean checkEdge(int from, int to) {
        if (directed) return matrix[from][to] == 1;
        else return matrix[from][to] == 1 && matrix[to][from] == 1;
    }

    @Override
    public void printGraph() {
        System.out.println("Printed Matrix: Directed is " + directed);
        for (int i = 0; i < matrix.length; i++) {
            if (i == 0) System.out.print("# ");
            System.out.print(nodes.get(i).data + " ");
        }
        System.out.println();
        int counter = 0;
        for (int[] matrixRow : matrix) {
            System.out.print(nodes.get(counter).data + " ");
            for (int matrixCol : matrixRow) {
                System.out.print(matrixCol + " ");
            }
            System.out.println();
            counter++;
        }
    }
}
