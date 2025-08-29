public class GraphEdge<T, W> {
    T srcNode;
    T dstNode;
    W weight;

    public GraphEdge(T srcNode, T dstNode, W weight) {
        this.srcNode = srcNode;
        this.dstNode = dstNode;
        this.weight = weight;
    }

    public String toString() {
        return "(" + srcNode + ", " + dstNode + ", " + weight + ")";
    }
}
