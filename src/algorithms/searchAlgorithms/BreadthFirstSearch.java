package algorithms.searchAlgorithms;

import dataStructs.AdjacencyMatrix;
import dataStructs.Node;

import java.util.LinkedList;
import java.util.Queue;

/*
The Breadth First Search (BFS) search algorithm is used to traverse through a graph or a tree
It works by starting at one node of the graph, and going through all its neighbors, aka a level
Then it goes through the neighbor's neighbors, and so on until the entire graph is traversed
This example uses an adjacency matrix

Time Complexity:
The time complexity for BFS is O(v + e) where v is the number of nodes and e is the number of edges

Space Complexity:
The space complexity is O(v) due to the creation of a queue
*/

public class BreadthFirstSearch {
    public static void breadthFirstSearch(int from, AdjacencyMatrix matrix) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.matrix.length];
        queue.offer(from);
        visited[from] = true; // Add the initial node to the queue and set its state to visited
        while (!queue.isEmpty()) {
            from = queue.poll(); // Obtain the next value of the queue and print it out
            System.out.println(matrix.nodes.get(from).data + " has been visited.");
            for (int i = 0; i < matrix.matrix[from].length; i++) { // Add neighbors to queue
                if (matrix.matrix[from][i] == 1 && !visited[i]) {
                    queue.offer(i); // Offer and set the node
                    visited[i] = true;
                }
            }
        }
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
        breadthFirstSearch(0, matrix);
    }
}
