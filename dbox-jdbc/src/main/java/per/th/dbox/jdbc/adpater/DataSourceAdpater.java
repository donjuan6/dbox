package per.th.dbox.jdbc.adpater;

import per.th.dbox.jdbc.unsupport.UnsupportedDataSource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public abstract
class DataSourceAdpater<T extends DataSource>
        extends UnsupportedDataSource<T> {

    private PrintWriter logWriter;
    private int loginTimeout;

    @Override
    public abstract Connection getConnection() throws SQLException;

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return logWriter;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        super.setLogWriter(out);
        this.logWriter = out;
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        super.setLoginTimeout(seconds);
        this.loginTimeout = seconds;
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return loginTimeout;
    }

}
