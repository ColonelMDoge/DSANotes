package algorithms.searchAlgorithms;

import dataStructs.AdjacencyMatrix;
import dataStructs.Node;

/*
The Depth First Search (DFS) search algorithm is used to traverse through a graph or a tree
It works by starting at one node of the graph, and going through its neighbors one branch at a time
When it reaches a dead end, it backtracks to a node with unvisited neighbors
This example uses an adjacency matrix

Time Complexity:
The time complexity for DFS is O(v + e) where v is the number of nodes and e is the number of edges

Space Complexity:
The space complexity is also O(v + e) due to the creation of a visited array and recursion
*/

public class DepthFirstSearch {
    private static void DFSHelper(int from, boolean[] visited, AdjacencyMatrix matrix) {
        if (!visited[from]) { // Only run the body if the node has not been visited before
            visited[from] = true;
            System.out.println(matrix.nodes.get(from).data + " has been visited.");
        } else return;
        for (int i = 0; i < matrix.matrix[from].length; i++) {
            // Check if there is an edge connection, then mark as visited if not already
            if (matrix.matrix[from][i] == 1) {
                DFSHelper(i, visited, matrix);
            }
        }
    }
    public static void depthFirstSearch(int from, AdjacencyMatrix matrix) {
        boolean[] visited = new boolean[matrix.matrix.length]; // boolean array to store visited edges
        DFSHelper(from, visited, matrix);
    }
    public static void main(String[] args) {
        AdjacencyMatrix matrix = new AdjacencyMatrix(5, true); // Directed graph
        matrix.addNode(new Node('A'));
        matrix.addNode(new Node('B'));
        matrix.addNode(new Node('C'));
        matrix.addNode(new Node('D'));
        matrix.addNode(new Node('E'));

        matrix.addEdge(0, 1);
        matrix.addEdge(1, 2);
        matrix.addEdge(1, 4);
        matrix.addEdge(2, 3);
        matrix.addEdge(2, 4);
        matrix.addEdge(4, 0);
        matrix.addEdge(4, 2);

        matrix.printGraph();

        System.out.println("Starting at: " + matrix.nodes.getFirst().data);
        depthFirstSearch(0, matrix);
    }
}
