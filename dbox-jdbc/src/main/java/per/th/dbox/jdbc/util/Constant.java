package per.th.dbox.jdbc.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public abstract
class Constant<C extends Constant<C>> {

    private static AtomicInteger N = new AtomicInteger();

    private final int id;
    private final String name;

    protected Constant(String name) {
        this.name = hasText(name);
        this.id = N.incrementAndGet();
    }

    public final int id() {
        return id;
    }

    public final String name() {
        return name;
    }

    @Override
    public final boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public final int hashCode() {
        return super.hashCode();
    }

    @Override
    public abstract String toString();

    private static String hasText(String text) {
        if (text == null || text.length() == 0) {
            throw new IllegalArgumentException("Constant name must not be null or empty text!");
        }
        return text.trim();
    }

}
