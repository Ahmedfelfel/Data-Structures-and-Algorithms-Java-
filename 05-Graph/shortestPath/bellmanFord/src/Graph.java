import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashSet;

public abstract class Graph<T, W extends Number & Comparable<W>> {
    List<GraphEdge<T, W>> edgeList;
    HashSet<T> vertices;

    public Graph() {
        vertices = new HashSet<>();
        edgeList = new ArrayList<>();
    }

    public void connect(T srcNode, T dstNode, W weight) {
        vertices.add(srcNode);
        vertices.add(dstNode);

        /* TODO: create a new GraphEdge and add it to edgeList */
        edgeList.add(new GraphEdge<>(srcNode,dstNode,weight));
    }

    protected abstract W add(W a, W b);

    public Map<T, GraphDistance<T, W>> bellmanFord(T startingNode, W startingDistance) {
        HashMap<T, GraphDistance<T, W>> dist = new HashMap<>();

        dist.put(startingNode, new GraphDistance<>(startingNode, startingDistance));

        /* TODO: implement the Bellman-Ford algorithm here */
        for(T vertex : vertices)
        {
            if(!vertex.equals(startingNode))
                dist.put(vertex,null);
        }
        for (int i = 0; i < vertices.size() - 1; i++) {
            for (GraphEdge<T, W> edge : edgeList) {
                T u = edge.srcNode;
                T v = edge.dstNode;
                W w = edge.weight;

                GraphDistance<T, W> du = dist.get(u);
                GraphDistance<T, W> dv = dist.get(v);

                if (du != null) {
                    W newDist = add(du.distance, w);
                    if (dv == null || newDist.compareTo(dv.distance) < 0) {
                        dist.put(v, new GraphDistance<>(u, newDist));
                    }
                }
            }
        }
        for (GraphEdge<T, W> edge : edgeList) {
            T u = edge.srcNode;
            T v = edge.dstNode;
            W w = edge.weight;

            GraphDistance<T, W> du = dist.get(u);
            GraphDistance<T, W> dv = dist.get(v);

            if (du != null) {
                W newDist = add(du.distance, w);
                if (dv == null || newDist.compareTo(dv.distance) < 0) {
                    throw new IllegalStateException("Negative weight cycle detected");
                }
            }
        }

        return dist;
    }
}
