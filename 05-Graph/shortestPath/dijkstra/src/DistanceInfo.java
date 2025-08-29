import org.jetbrains.annotations.NotNull;

public class DistanceInfo<T, W extends Comparable<W>> implements Comparable<DistanceInfo<T, W>> {
    T node;
    W distance;

    public DistanceInfo(T node, W distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public int compareTo(@NotNull DistanceInfo<T, W> o) {
        return distance.compareTo(o.distance);
    }
}
