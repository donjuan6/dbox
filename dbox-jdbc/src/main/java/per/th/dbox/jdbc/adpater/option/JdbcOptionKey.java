package per.th.dbox.jdbc.adpater.option;

import per.th.dbox.jdbc.util.Constant;
import per.th.dbox.jdbc.util.ConstantPool;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public final
class JdbcOptionKey<T>
        extends Constant<JdbcOptionKey<?>> {

    private static final ConstantPool<JdbcOptionKey<?>> constantPool
            = ConstantPool.withInitial(JdbcOptionKey::new);

    protected JdbcOptionKey(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "JDBC Option:" + name();
    }

    public static <T> JdbcOptionKey<T> get(String name) {
        return (JdbcOptionKey<T>) constantPool.getOrThrow(name);
    }

    public static <T> JdbcOptionKey<T> of(String name) {
        return (JdbcOptionKey<T>) constantPool.getOrCreate(name);
    }

}
