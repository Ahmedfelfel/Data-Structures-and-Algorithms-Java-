import java.util.List;
import java.util.ArrayList;

public class Graph<T, W> {
    List<GraphEdge<T, W>> edgeList;

    public Graph() {
        edgeList = new ArrayList<>();
    }

    public void connect(T srcNode, T dstNode, W weight) {
        /* TODO: create a new GraphEdge and add it to edgeList */
        edgeList.add(new GraphEdge<>(srcNode,dstNode,weight));
    }
}