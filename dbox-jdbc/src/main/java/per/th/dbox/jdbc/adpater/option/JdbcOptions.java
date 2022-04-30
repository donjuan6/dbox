package per.th.dbox.jdbc.adpater.option;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public class JdbcOptions {

    private final Map<JdbcOptionKey<?>, JdbcOption<?>> m;

    public JdbcOptions() {
        this.m = new HashMap<>();
    }

    public JdbcOptions(Map<?, ?> m) {
        this.m = (Map<JdbcOptionKey<?>, JdbcOption<?>>) m;
    }

    public boolean hasOption(JdbcOptionKey<?> key) {
        return m.containsKey(key);
    }

    public <V> JdbcOption<V> option(JdbcOptionKey<V> key) {
        JdbcOption<V> res = (JdbcOption<V>) m.get(key);
        return res == null ? new Empty<>(key) : res;
    }

    public <V> V optionValue(JdbcOptionKey<V> key) {
        return option(key).get();
    }

    public <V> void option(JdbcOptionKey<V> key, JdbcOption<V> value) {
        m.put(key, value);
    }

    public <V> JdbcOption<V> optionValue(JdbcOptionKey<V> key, V value) {
        JdbcOption<V> option = new JdbcOption<>(key, value);
        option(key, option);
        return option;
    }

    private static class Empty<V> extends JdbcOption<V> {

        public Empty(JdbcOptionKey<V> key) {
            super(key, null);
        }

        @Override
        public V get() {
            throw new NoSuchElementException();
        }

        @Override
        public Optional<V> optional() {
            return Optional.empty();
        }

    }
}
