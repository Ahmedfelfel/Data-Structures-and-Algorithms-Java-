public class LongGraph<T> extends Graph<T, Long> {
    @Override
    protected Long add(Long a, Long b) {
        return a + b;
    }
}
