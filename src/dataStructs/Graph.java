package dataStructs;

// The Graph interface has four methods to override
// These methods allow for the creation of a graph
public interface Graph {
    void addNode(Node node);
    void addEdge(int from, int to);
    boolean checkEdge(int from, int to);
    void printGraph();
}
