package per.th.dbox.jdbc.delegating;

import java.sql.SQLException;
import java.sql.Wrapper;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public abstract
class DelegatingWrapper<E extends Wrapper>
        extends Delegateable<E>
        implements Wrapper {

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        if (!iface.isInstance(this)) {
            E e = obtainTargetObject();
            return e == null ? null : e.unwrap(iface);
        } else {
            return (T) this;
        }
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        if (!iface.isInstance(this)) {
            E e = obtainTargetObject();
            return e != null && e.isWrapperFor(iface);
        } else {
            return true;
        }
    }

}
