import java.util.Map;
import java.util.HashMap;

public class Graph<T, W> {
    Map<T, Map<T, W>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    private void addNode(T node) {
        /* TODO: implement an adjacency list (map) creation */
        adjList.put(node,new HashMap<>());
    }

    public void connect(T srcNode, T dstNode, W weight) {
        if (!adjList.containsKey(srcNode))
            addNode(srcNode);

        if (!adjList.containsKey(dstNode))
            addNode(dstNode);

        /* TODO: create a directed edge */
        adjList.get(srcNode).put(dstNode,weight);
    }

    public Map<T, W> neighborsOf(T node) {
        /* TODO: returns the adjacency list (map) of the node */
        return adjList.get(node);
    }
}