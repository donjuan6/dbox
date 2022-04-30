package per.th.dbox.jdbc.adpater;

import per.th.dbox.jdbc.adpater.option.JdbcOptionKey;
import per.th.dbox.jdbc.adpater.option.JdbcOptions;
import per.th.dbox.jdbc.unsupport.UnsupportedConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public abstract
class ConnectionAdpater<T extends Connection>
        extends UnsupportedConnection<T> {

    public static JdbcOptionKey<Boolean> AUTO_COMMIT = JdbcOptionKey.of("auto-commit");
    public static JdbcOptionKey<String> CATALOG = JdbcOptionKey.of("catalog");
    public static JdbcOptionKey<Integer> TRANSACTION_ISOLATION = JdbcOptionKey.of("transaction-isolation");
    public static JdbcOptionKey<Boolean> READ_ONLY = JdbcOptionKey.of("read-only");
    public static JdbcOptionKey<Map<String, Class<?>>> TYPE_MAP = JdbcOptionKey.of("type-map");
    public static JdbcOptionKey<Integer> HOLDABILITY = JdbcOptionKey.of("holdability");
    public static JdbcOptionKey<String> SCHEMA = JdbcOptionKey.of("schema");
    public static JdbcOptionKey<Integer> NETWORK_TIMEOUT = JdbcOptionKey.of("network-timeout");
    public static JdbcOptionKey<Integer> RESULT_SET_TYPE = JdbcOptionKey.of("result-set-type");
    public static JdbcOptionKey<Integer> RESULT_SET_CONCURRENCY = JdbcOptionKey.of("result-set-concurrency");
    public static JdbcOptionKey<Integer> RESULT_SET_HOLDABILITY = JdbcOptionKey.of("result-set-holdability");
    public static JdbcOptionKey<Integer> AUTO_GENERATED_KEYS = JdbcOptionKey.of("auto-generated-keys");
    public static JdbcOptionKey<int[]> COLUMN_INDEXES = JdbcOptionKey.of("columnIndexes");
    public static JdbcOptionKey<String[]> COLUMN_NAMES = JdbcOptionKey.of("columnNames");

    private JdbcOptions options = new JdbcOptions();

    // ------------------------------------------------------------ Option Operation

    protected final <T> T option(JdbcOptionKey<T> key) {
        return options.optionValue(key);
    }

    protected final <T> void option(JdbcOptionKey<T> key, T value) {
        options.optionValue(key, value);
    }

    // ------------------------------------------------------------ Options

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        super.setAutoCommit(autoCommit);
        option(AUTO_COMMIT, autoCommit);
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return option(AUTO_COMMIT);
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {
        super.setCatalog(catalog);
        option(CATALOG, catalog);
    }

    @Override
    public String getCatalog() throws SQLException {
        return option(CATALOG);
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        super.setTransactionIsolation(level);
        option(TRANSACTION_ISOLATION, level);
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return option(TRANSACTION_ISOLATION);
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        super.setReadOnly(readOnly);
        option(READ_ONLY, readOnly);
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return option(READ_ONLY);
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return option(TYPE_MAP);
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        super.setTypeMap(map);
        option(TYPE_MAP, map);
    }

    @Override
    public void setHoldability(int holdability) throws SQLException {
        super.setHoldability(holdability);
        option(HOLDABILITY, holdability);
    }

    @Override
    public int getHoldability() throws SQLException {
        return option(HOLDABILITY);
    }

    @Override
    public void setSchema(String schema) throws SQLException {
        super.setSchema(schema);
        option(SCHEMA, schema);
    }

    @Override
    public String getSchema() throws SQLException {
        return option(SCHEMA);
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        super.setNetworkTimeout(executor, milliseconds);
        option(NETWORK_TIMEOUT, milliseconds);
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        return option(NETWORK_TIMEOUT);
    }

    // ------------------------------------------------------------ Statement Operation

    @Override
    public abstract PreparedStatement prepareStatement(String sql) throws SQLException;

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        option(RESULT_SET_TYPE, resultSetType);
        option(RESULT_SET_CONCURRENCY, resultSetConcurrency);
        return prepareStatement(sql);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        option(RESULT_SET_HOLDABILITY, resultSetHoldability);
        return this.prepareStatement(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        option(AUTO_GENERATED_KEYS, autoGeneratedKeys);
        return this.prepareStatement(sql);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        option(COLUMN_INDEXES, columnIndexes);
        return this.prepareStatement(sql);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        option(COLUMN_NAMES, columnNames);
        return this.prepareStatement(sql);
    }

    @Override
    public abstract Statement createStatement() throws SQLException;

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        option(RESULT_SET_TYPE, resultSetType);
        option(RESULT_SET_CONCURRENCY, resultSetConcurrency);
        return createStatement();
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        option(RESULT_SET_HOLDABILITY, resultSetHoldability);
        return this.createStatement(resultSetType, resultSetConcurrency);
    }

}
