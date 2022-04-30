package per.th.dbox.jdbc.unsupport;

import per.th.dbox.jdbc.delegating.DelegatingDataSource;

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
class UnsupportedDataSource<T extends DataSource>
        extends DelegatingDataSource<T> {

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        throw new SQLFeatureNotSupportedException("Unsupported jdbc operation!");
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException("Unsupported jdbc operation!");
    }

}
