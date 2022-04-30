package per.th.dbox.jdbc.delegating;

import java.sql.SQLException;
import java.util.Objects;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public abstract
class Delegateable<E> {

    protected E getTargetObject() throws SQLException {
        E res = obtainTargetObject();
        Objects.requireNonNull(res, "ObtainTargetObject() return null!");
        return res;
    }

    protected abstract E obtainTargetObject() throws SQLException;

}
