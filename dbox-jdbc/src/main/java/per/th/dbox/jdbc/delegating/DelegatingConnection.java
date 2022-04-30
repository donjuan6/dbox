package per.th.dbox.jdbc.delegating;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public abstract
class DelegatingConnection<T extends Connection>
        extends DelegatingWrapper<T>
        implements Connection {

    @Override
    public Statement createStatement() throws SQLException {
        return getTargetObject().createStatement();
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return getTargetObject().prepareStatement(sql);
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        return getTargetObject().prepareCall(sql);
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
        return getTargetObject().nativeSQL(sql);
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        getTargetObject().setAutoCommit(autoCommit);
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return getTargetObject().getAutoCommit();
    }

    @Override
    public void commit() throws SQLException {
        getTargetObject().commit();
    }

    @Override
    public void rollback() throws SQLException {
        getTargetObject().rollback();
    }

    @Override
    public void close() throws SQLException {
        getTargetObject().close();
    }

    @Override
    public boolean isClosed() throws SQLException {
        return getTargetObject().isClosed();
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return getTargetObject().getMetaData();
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        getTargetObject().setReadOnly(readOnly);
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return getTargetObject().isReadOnly();
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {
        getTargetObject().setCatalog(catalog);
    }

    @Override
    public String getCatalog() throws SQLException {
        return getTargetObject().getCatalog();
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        getTargetObject().setTransactionIsolation(level);
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return getTargetObject().getTransactionIsolation();
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
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return getTargetObject().createStatement(resultSetType, resultSetConcurrency);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return getTargetObject().prepareStatement(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return getTargetObject().prepareCall(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return getTargetObject().getTypeMap();
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        getTargetObject().setTypeMap(map);
    }

    @Override
    public void setHoldability(int holdability) throws SQLException {
        getTargetObject().setHoldability(holdability);
    }

    @Override
    public int getHoldability() throws SQLException {
        return getTargetObject().getHoldability();
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        return getTargetObject().setSavepoint();
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        return getTargetObject().setSavepoint(name);
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
        getTargetObject().rollback(savepoint);
    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        getTargetObject().releaseSavepoint(savepoint);
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return getTargetObject().createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return getTargetObject().prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return getTargetObject().prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return getTargetObject().prepareStatement(sql, autoGeneratedKeys);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return getTargetObject().prepareStatement(sql, columnIndexes);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return getTargetObject().prepareStatement(sql, columnNames);
    }

    @Override
    public Clob createClob() throws SQLException {
        return getTargetObject().createClob();
    }

    @Override
    public Blob createBlob() throws SQLException {
        return getTargetObject().createBlob();
    }

    @Override
    public NClob createNClob() throws SQLException {
        return getTargetObject().createNClob();
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        return getTargetObject().createSQLXML();
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
        return getTargetObject().isValid(timeout);
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        try {
            getTargetObject().setClientInfo(name, value);
        } catch (SQLException e) {
            throw new SQLClientInfoException("Can not get target connection!", Collections.emptyMap(), e);
        }
    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        try {
            getTargetObject().setClientInfo(properties);
        } catch (SQLException e) {
            throw new SQLClientInfoException("Can not get target connection!", Collections.emptyMap(), e);
        }
    }

    @Override
    public String getClientInfo(String name) throws SQLException {
        return getTargetObject().getClientInfo(name);
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        return getTargetObject().getClientInfo();
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return getTargetObject().createArrayOf(typeName, elements);
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return getTargetObject().createStruct(typeName, attributes);
    }

    @Override
    public void setSchema(String schema) throws SQLException {
        getTargetObject().setSchema(schema);
    }

    @Override
    public String getSchema() throws SQLException {
        return getTargetObject().getSchema();
    }

    @Override
    public void abort(Executor executor) throws SQLException {
        getTargetObject().abort(executor);
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        getTargetObject().setNetworkTimeout(executor, milliseconds);
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        return getTargetObject().getNetworkTimeout();
    }

}
