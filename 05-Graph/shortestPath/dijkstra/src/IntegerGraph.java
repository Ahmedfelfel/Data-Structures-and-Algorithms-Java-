public class IntegerGraph<T> extends Graph<T, Integer> {
    @Override
    protected Integer add(Integer a, Integer b) {
        return a + b;
    }
}
