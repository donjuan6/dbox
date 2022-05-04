package per.th.dbox.jdbc.adpater;

import per.th.dbox.jdbc.adpater.option.JdbcOptionKey;
import per.th.dbox.jdbc.adpater.option.JdbcOptions;
import per.th.dbox.jdbc.adpater.param.JdbcParameters;
import per.th.dbox.jdbc.unsupport.UnsupportedPreparedStatement;

import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public abstract
class PreparedStatementAdpater<T extends PreparedStatement>
        extends UnsupportedPreparedStatement<T> {

    public static JdbcOptionKey<Integer> RESULT_SET_TYPE = JdbcOptionKey.of("result-set-type");
    public static JdbcOptionKey<Integer> RESULT_SET_CONCURRENCY = JdbcOptionKey.of("result-set-concurrency");
    public static JdbcOptionKey<Integer> RESULT_SET_HOLDABILITY = JdbcOptionKey.of("result-set-holdability");
    public static JdbcOptionKey<Integer> AUTO_GENERATED_KEYS = JdbcOptionKey.of("auto-generated-keys");
    public static JdbcOptionKey<int[]> COLUMN_INDEXES = JdbcOptionKey.of("columnIndexes");
    public static JdbcOptionKey<String[]> COLUMN_NAMES = JdbcOptionKey.of("columnNames");

    private JdbcOptions options = new JdbcOptions();
    private JdbcParameters parameters = new JdbcParameters();

    @Override
    protected T obtainTargetObject() throws SQLException {
        return (T) parameters.getProxy();
    }

    // ------------------------------------------------------------ Option Operation

    protected final <T> T option(JdbcOptionKey<T> key) {
        return options.optionValue(key);
    }

    protected final <T> void option(JdbcOptionKey<T> key, T value) {
        options.optionValue(key, value);
    }

    // ------------------------------------------------------------ Properties

    @Override
    public int getMaxRows() throws SQLException {
        return super.getMaxRows();
    }

    @Override
    public void setMaxRows(int max) throws SQLException {
        super.setMaxRows(max);
    }

    @Override
    public int getQueryTimeout() throws SQLException {
        return super.getQueryTimeout();
    }

    @Override
    public void setQueryTimeout(int seconds) throws SQLException {
        super.setQueryTimeout(seconds);
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException {
        super.setFetchDirection(direction);
    }

    @Override
    public int getFetchDirection() throws SQLException {
        return super.getFetchDirection();
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {
        super.setFetchSize(rows);
    }

    @Override
    public int getFetchSize() throws SQLException {
        return super.getFetchSize();
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
        return super.getResultSetConcurrency();
    }

    @Override
    public int getResultSetType() throws SQLException {
        return super.getResultSetType();
    }

    @Override
    public void setLargeMaxRows(long max) throws SQLException {
        super.setLargeMaxRows(max);
    }

    @Override
    public long getLargeMaxRows() throws SQLException {
        return super.getLargeMaxRows();
    }

    // ------------------------------------------------------------ Parameter

//    @Override
//    public void setNull(int parameterIndex, int sqlType) throws SQLException {
//        parameters.setParameter(parameterIndex, null, (stmt, i) -> stmt.setNull(i, sqlType));
//    }
//
//    @Override
//    public void setBoolean(int parameterIndex, boolean x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setByte(int parameterIndex, byte x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setByte(i, x));
//    }
//
//    @Override
//    public void setShort(int parameterIndex, short x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setShort(i, x));
//    }
//
//    @Override
//    public void setInt(int parameterIndex, int x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setInt(i, x));
//    }
//
//    @Override
//    public void setLong(int parameterIndex, long x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setLong(i, x));
//    }
//
//    @Override
//    public void setFloat(int parameterIndex, float x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setFloat(i, x));
//    }
//
//    @Override
//    public void setDouble(int parameterIndex, double x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setDouble(i, x));
//    }
//
//    @Override
//    public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBigDecimal(i, x));
//    }
//
//    @Override
//    public void setString(int parameterIndex, String x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setString(i, x));
//    }
//
//    @Override
//    public void setBytes(int parameterIndex, byte[] x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBytes(i, x));
//    }
//
//    @Override
//    public void setDate(int parameterIndex, Date x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setDate(i, x));
//    }
//
//    @Override
//    public void setTime(int parameterIndex, Time x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setTime(i, x));
//    }
//
//    @Override
//    public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setTimestamp(i, x));
//    }
//
//    @Override
//    public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setAsciiStream(i, x, length));
//    }
//
//    @Override
//    public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setUnicodeStream(i, x, length));
//    }
//
//    @Override
//    public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBinaryStream(i, x, length));
//    }
//
//    @Override
//    public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setObject(i, x, targetSqlType));
//    }
//
//    @Override
//    public void setObject(int parameterIndex, Object x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setObject(i, x));
//    }
//
//    @Override
//    public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
//        parameters.setParameter(parameterIndex, reader, (stmt, i) -> stmt.setCharacterStream(i, reader, length));
//    }
//
//    @Override
//    public void setRef(int parameterIndex, Ref x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setRef(i, x));
//    }
//
//    @Override
//    public void setBlob(int parameterIndex, Blob x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBlob(i, x));
//    }
//
//    @Override
//    public void setClob(int parameterIndex, Clob x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setClob(i, x));
//    }
//
//    @Override
//    public void setArray(int parameterIndex, Array x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setArray(i, x));
//    }
//
//    @Override
//    public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setDate(i, x, cal));
//    }
//
//    @Override
//    public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setTime(i, x, cal));
//    }
//
//    @Override
//    public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setTimestamp(i, x, cal));
//    }
//
//    @Override
//    public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
//        parameters.setParameter(parameterIndex, null, (stmt, i) -> stmt.setNull(i, sqlType, typeName));
//    }
//
//    @Override
//    public void setURL(int parameterIndex, URL x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setURL(i, x));
//    }
//
//    @Override
//    public void setRowId(int parameterIndex, RowId x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setNString(int parameterIndex, String value) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setNClob(int parameterIndex, NClob value) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setClob(int parameterIndex, Reader reader) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setNClob(int parameterIndex, Reader reader) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setObject(int parameterIndex, Object x, SQLType targetSqlType, int scaleOrLength) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }
//
//    @Override
//    public void setObject(int parameterIndex, Object x, SQLType targetSqlType) throws SQLException {
//        parameters.setParameter(parameterIndex, x, (stmt, i) -> stmt.setBoolean(i, x));
//    }

    // ------------------------------------------------------------ Execute

    @Override
    public abstract boolean execute(String logicSql) throws SQLException;

    @Override
    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
        option(AUTO_GENERATED_KEYS, autoGeneratedKeys);
        return this.execute(sql);
    }

    @Override
    public boolean execute(String sql, int[] columnIndexes) throws SQLException {
        option(COLUMN_INDEXES, columnIndexes);
        return this.execute(sql);
    }

    @Override
    public boolean execute(String sql, String[] columnNames) throws SQLException {
        option(COLUMN_NAMES, columnNames);
        return this.execute(sql);
    }

    @Override
    public abstract ResultSet executeQuery(String logicSql) throws SQLException;

    @Override
    public abstract int executeUpdate(String logicSql) throws SQLException;

    @Override
    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        option(AUTO_GENERATED_KEYS, autoGeneratedKeys);
        return this.executeUpdate(sql);
    }

    @Override
    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
        option(COLUMN_INDEXES, columnIndexes);
        return this.executeUpdate(sql);
    }

    @Override
    public int executeUpdate(String sql, String[] columnNames) throws SQLException {
        option(COLUMN_NAMES, columnNames);
        return this.executeUpdate(sql);
    }

}
