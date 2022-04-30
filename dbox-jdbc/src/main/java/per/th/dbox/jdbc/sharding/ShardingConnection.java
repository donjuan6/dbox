package per.th.dbox.jdbc.sharding;

import per.th.dbox.jdbc.adpater.ConnectionAdpater;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public
class ShardingConnection
        extends ConnectionAdpater<ShardingConnection> {

    private final ShardingDataSource dataSource;

    public ShardingConnection(ShardingDataSource dataSource) {
        this.dataSource = Objects.requireNonNull(dataSource, "Argument 'dataSource' must not be null!");
    }

    @Override
    protected ShardingConnection obtainTargetObject() throws SQLException {
        return null;
    }

    @Override
    public ShardingPreparedStatement prepareStatement(String sql) throws SQLException {
        return new ShardingPreparedStatement(this, sql);
    }

    @Override
    public Statement createStatement() throws SQLException {
        return null;
    }

}
