import java.util.*;
import java.util.function.Consumer;

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
            this.addNode(srcNode);

        if (!adjList.containsKey(dstNode))
            this.addNode(dstNode);

        /* TODO: create a directed edge */
        adjList.get(srcNode).put(dstNode,weight);
    }

    public Map<T, W> neighborsOf(T node) {
        /* TODO: returns the adjacency list (map) of the node */
        return adjList.get(node);
    }

    public void search(T startingNode, Consumer<GraphEdge<T, W>> processor) {
        Map<T, Boolean> visited = new HashMap<>();
        Map<T, T> parent = new HashMap<>();
        Queue<T> q = new ArrayDeque<>();

        parent.put(startingNode, startingNode);
        q.add(startingNode);

        while (!q.isEmpty()) {
            T srcNode = q.poll();
            T parentNode = parent.get(srcNode);

            visited.put(srcNode, true);

            // DO NOT TOUCH - process the node
            if (!parentNode.equals(srcNode))
            {
                processor.accept(new GraphEdge<>(parentNode, srcNode,
                        adjList.get(parentNode).get(srcNode)));
            }
            /* TODO: for each neighbor of srcNode, add to queue if it was not visited */
            for(T neighbor : neighborsOf(srcNode).keySet())
            {
                if(!visited.containsKey(neighbor))
                {
                    visited.put(neighbor,true);
                    parent.put(neighbor, srcNode);
                    q.add(neighbor);
                }
            }
        }
    }
}