public class GraphDistance<T, W> {
    T parent;
    W distance;

    public GraphDistance(T parent, W distance) {
        this.parent = parent;
        this.distance = distance;
    }
}
