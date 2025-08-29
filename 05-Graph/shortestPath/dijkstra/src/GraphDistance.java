import org.jetbrains.annotations.NotNull;

public class GraphDistance<T, W extends Comparable<W>> implements Comparable<GraphDistance<T, W>> {
    T parent;
    W distance;

    public GraphDistance(T parent, W distance) {
        this.parent = parent;
        this.distance = distance;
    }

    @Override
    public int compareTo(@NotNull GraphDistance<T, W> o) {
        return distance.compareTo(o.distance);
    }
}
