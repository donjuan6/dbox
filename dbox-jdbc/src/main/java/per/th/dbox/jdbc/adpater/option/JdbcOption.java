package per.th.dbox.jdbc.adpater.option;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public class JdbcOption<V> implements Supplier<V> {

    private final JdbcOptionKey<V> key;
    private V value;

    public JdbcOption(JdbcOptionKey<V> key, V value) {
        this.key = key;
        this.value = value;
    }

    public JdbcOptionKey<V> key() {
        return key;
    }

    public void set(V value) {
        this.value = value;
    }

    @Override
    public V get() {
        if (value == null) {
            throw new NoSuchElementException("Not Found " + key);
        }
        return value;
    }

    public Optional<V> optional() {
        return Optional.ofNullable(value);
    }

    @Override
    public String toString() {
        return "JdbcOption{" +
                "value=" + value +
                '}';
    }

}
