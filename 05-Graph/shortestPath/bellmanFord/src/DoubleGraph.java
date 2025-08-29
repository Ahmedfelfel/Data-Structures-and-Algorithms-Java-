public class DoubleGraph<T> extends Graph<T, Double> {
    @Override
    protected Double add(Double a, Double b) {
        return a + b;
    }
}
