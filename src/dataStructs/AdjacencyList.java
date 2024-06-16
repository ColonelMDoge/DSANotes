package dataStructs;

import java.util.ArrayList;
import java.util.LinkedList;

/*
An adjacency list is a data structure used to show the connections between different nodes in a graph
It uses an ArrayList of LinkedLists to represents each edge
A connection is denoted with an arrow
Each row represents the referenced node, and everything beside it represents the node's neighbors

Time complexity:
The time complexity to check an edge connection is O(v) where v is the number of nodes

Space complexity:
The space complexity is O(v + e) where v is the node and e is each edge
 */

public class AdjacencyList implements Graph {
    ArrayList<LinkedList<Node>> list;
    boolean directed;

    public AdjacencyList(boolean directed) {
        list = new ArrayList<>();
        this.directed = directed;
    }
    @Override
    public void addNode(Node node) {
        LinkedList<Node> nodeList = new LinkedList<>();
        nodeList.add(node);
        list.add(nodeList);
    }

    @Override
    public void addEdge(int from, int to) {
        if (directed) {
            LinkedList<Node> fromNode = list.get(from);
            Node toNode = list.get(to).getFirst();
            fromNode.add(toNode);
        } else {
            LinkedList<Node> fromNodeList = list.get(from);
            Node toNode = list.get(to).getFirst();
            fromNodeList.add(toNode);

            LinkedList<Node> toNodeList = list.get(to);
            Node fromNode = list.get(from).getFirst();
            toNodeList.add(fromNode);
        }

    }

    @Override
    public boolean checkEdge(int from, int to) {
        LinkedList<Node> fromNode = list.get(from);
        if (directed) {
            Node toNode = list.get(to).getFirst();
            for (Node node : fromNode) {
                if (node.equals(toNode)) return true;
            }
            return false;
        } else {
            LinkedList<Node> toNode = list.get(to);
            boolean fromConnection = false;
            boolean toConnection = false;
            for (Node node : fromNode) {
                if (node.data == to) {
                    fromConnection = true;
                    break;
                }
            }
            for (Node node : toNode) {
                if (node.data == from) {
                    toConnection = true;
                    break;
                }
            }
            return fromConnection && toConnection;
        }
    }

    @Override
    public void printGraph() {
        System.out.println("Printed List: Directed is " + directed);
        for (LinkedList<Node> nodeList : list) {
            for (Node node : nodeList) {
                System.out.print(node.data + " -> ");
            }
            System.out.println();
        }
    }
}
