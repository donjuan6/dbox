package per.th.dbox.jdbc.delegating;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public abstract
class DelegatingStatement<T extends Statement>
        extends DelegatingWrapper<T>
        implements Statement {

    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
        return getTargetObject().executeQuery(sql);
    }

    @Override
    public int executeUpdate(String sql) throws SQLException {
        return getTargetObject().executeUpdate(sql);
    }

    @Override
    public void close() throws SQLException {
        getTargetObject().close();
    }

    @Override
    public int getMaxFieldSize() throws SQLException {
        return getTargetObject().getMaxFieldSize();
    }

    @Override
    public void setMaxFieldSize(int max) throws SQLException {
        getTargetObject().setMaxFieldSize(max);
    }

    @Override
    public int getMaxRows() throws SQLException {
        return getTargetObject().getMaxRows();
    }

    @Override
    public void setMaxRows(int max) throws SQLException {
        getTargetObject().setMaxRows(max);
    }

    @Override
    public void setEscapeProcessing(boolean enable) throws SQLException {
        getTargetObject().setEscapeProcessing(enable);
    }

    @Override
    public int getQueryTimeout() throws SQLException {
        return getTargetObject().getQueryTimeout();
    }

    @Override
    public void setQueryTimeout(int seconds) throws SQLException {
        getTargetObject().setQueryTimeout(seconds);
    }

    @Override
    public void cancel() throws SQLException {
        getTargetObject().cancel();
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return getTargetObject().getWarnings();
    }

    @Override
    public void clearWarnings() throws SQLException {
        getTargetObject().clearWarnings();
    }

    @Override
    public void setCursorName(String name) throws SQLException {
        getTargetObject().setCursorName(name);
    }

    @Override
    public boolean execute(String sql) throws SQLException {
        return getTargetObject().execute(sql);
    }

    @Override
    public ResultSet getResultSet() throws SQLException {
        return getTargetObject().getResultSet();
    }

    @Override
    public int getUpdateCount() throws SQLException {
        return getTargetObject().getUpdateCount();
    }

    @Override
    public boolean getMoreResults() throws SQLException {
        return getTargetObject().getMoreResults();
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException {
        getTargetObject().setFetchDirection(direction);
    }

    @Override
    public int getFetchDirection() throws SQLException {
        return getTargetObject().getFetchDirection();
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {
        getTargetObject().setFetchSize(rows);
    }

    @Override
    public int getFetchSize() throws SQLException {
        return getTargetObject().getFetchSize();
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
        return getTargetObject().getResultSetConcurrency();
    }

    @Override
    public int getResultSetType() throws SQLException {
        return getTargetObject().getResultSetType();
    }

    @Override
    public void addBatch(String sql) throws SQLException {
        getTargetObject().addBatch(sql);
    }

    @Override
    public void clearBatch() throws SQLException {
        getTargetObject().clearBatch();
    }

    @Override
    public int[] executeBatch() throws SQLException {
        return getTargetObject().executeBatch();
    }

    @Override
    public Connection getConnection() throws SQLException {
        return getTargetObject().getConnection();
    }

    @Override
    public boolean getMoreResults(int current) throws SQLException {
        return getTargetObject().getMoreResults(current);
    }

    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
        return getTargetObject().getGeneratedKeys();
    }

    @Override
    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        return getTargetObject().executeUpdate(sql, autoGeneratedKeys);
    }

    @Override
    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
        return getTargetObject().executeUpdate(sql, columnIndexes);
    }

    @Override
    public int executeUpdate(String sql, String[] columnNames) throws SQLException {
        return getTargetObject().executeUpdate(sql, columnNames);
    }

    @Override
    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
        return getTargetObject().execute(sql, autoGeneratedKeys);
    }

    @Override
    public boolean execute(String sql, int[] columnIndexes) throws SQLException {
        return getTargetObject().execute(sql, columnIndexes);
    }

    @Override
    public boolean execute(String sql, String[] columnNames) throws SQLException {
        return getTargetObject().execute(sql, columnNames);
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
        return getTargetObject().getResultSetHoldability();
    }

    @Override
    public boolean isClosed() throws SQLException {
        return getTargetObject().isClosed();
    }

    @Override
    public void setPoolable(boolean poolable) throws SQLException {
        getTargetObject().setPoolable(poolable);
    }

    @Override
    public boolean isPoolable() throws SQLException {
        return getTargetObject().isPoolable();
    }

    @Override
    public void closeOnCompletion() throws SQLException {
        getTargetObject().closeOnCompletion();
    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        return getTargetObject().isCloseOnCompletion();
    }

    @Override
    public long getLargeUpdateCount() throws SQLException {
        return getTargetObject().getLargeUpdateCount();
    }

    @Override
    public void setLargeMaxRows(long max) throws SQLException {
        getTargetObject().setLargeMaxRows(max);
    }

    @Override
    public long getLargeMaxRows() throws SQLException {
        return getTargetObject().getLargeMaxRows();
    }

    @Override
    public long[] executeLargeBatch() throws SQLException {
        return getTargetObject().executeLargeBatch();
    }

    @Override
    public long executeLargeUpdate(String sql) throws SQLException {
        return getTargetObject().executeLargeUpdate(sql);
    }

    @Override
    public long executeLargeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        return getTargetObject().executeLargeUpdate(sql, autoGeneratedKeys);
    }

    @Override
    public long executeLargeUpdate(String sql, int[] columnIndexes) throws SQLException {
        return getTargetObject().executeLargeUpdate(sql, columnIndexes);
    }

    @Override
    public long executeLargeUpdate(String sql, String[] columnNames) throws SQLException {
        return getTargetObject().executeLargeUpdate(sql, columnNames);
    }

}
