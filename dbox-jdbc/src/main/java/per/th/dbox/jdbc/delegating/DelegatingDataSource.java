package per.th.dbox.jdbc.delegating;

import per.th.dbox.jdbc.util.ExceptionUtils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public abstract
class DelegatingDataSource<E extends DataSource>
        extends DelegatingWrapper<E>
        implements DataSource {

    @Override
    public Connection getConnection() throws SQLException {
        return getTargetObject().getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return getTargetObject().getConnection(username, password);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return getTargetObject().getLogWriter();
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        getTargetObject().setLogWriter(out);
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        getTargetObject().setLoginTimeout(seconds);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return getTargetObject().getLoginTimeout();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        try {
            return getTargetObject().getParentLogger();
        } catch (SQLException e) {
            throw new SQLFeatureNotSupportedException("Can not get target datasource!", e);
        }
    }

}
