package per.th.dbox.jdbc.sharding;

import per.th.dbox.jdbc.adpater.PreparedStatementAdpater;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public
class ShardingPreparedStatement
        extends PreparedStatementAdpater<ShardingPreparedStatement> {

    private final ShardingConnection connection;
    private final String originalSql;

    public ShardingPreparedStatement(ShardingConnection connection, String originalSql) {
        this.connection = Objects.requireNonNull(connection, "Argument 'connection' must not be null!");
        this.originalSql = Objects.requireNonNull(originalSql, "Argument 'originalSql' must not be null!");
    }

    @Override
    protected ShardingPreparedStatement obtainTargetObject() throws SQLException {
        return null;
    }

    @Override
    public boolean execute() throws SQLException {
        return this.execute(originalSql);
    }

    @Override
    public boolean execute(String logicSql) throws SQLException {
        return doExecute(logicSql, PreparedStatement::execute);
    }

    @Override
    public ResultSet executeQuery() throws SQLException {
        return this.executeQuery(originalSql);
    }

    @Override
    public ResultSet executeQuery(String logicSql) throws SQLException {
        return doExecute(logicSql, PreparedStatement::executeQuery);
    }

    @Override
    public int executeUpdate() throws SQLException {
        return this.executeUpdate(originalSql);
    }

    @Override
    public int executeUpdate(String logicSql) throws SQLException {
        return doExecute(logicSql, PreparedStatement::executeUpdate);
    }

    protected <T> T doExecute(String sql, Execution<T> func) throws SQLException {
        return null;
    }

    @Override
    public boolean isClosed() throws SQLException {
        return super.isClosed();
    }

    @Override
    public void close() throws SQLException {
        super.close();
    }

    @Override
    public void cancel() throws SQLException {
        super.cancel();
    }

    @Override
    public Connection getConnection() throws SQLException {
        return connection;
    }

    private interface Execution<T> {
        T execute(PreparedStatement statement) throws SQLException;
    }
}
