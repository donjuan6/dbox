package per.th.dbox.jdbc.sharding;

import per.th.dbox.jdbc.adpater.ResultSetAdpater;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public
class ShardingResultSet
        extends ResultSetAdpater<ShardingResultSet> {

    @Override
    protected ShardingResultSet obtainTargetObject() throws SQLException {
        return null;
    }

}
