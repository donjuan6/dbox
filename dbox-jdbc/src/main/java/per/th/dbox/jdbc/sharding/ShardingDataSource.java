package per.th.dbox.jdbc.sharding;

import per.th.dbox.jdbc.adpater.DataSourceAdpater;
import per.th.dbox.jdbc.exception.DataSourceNoFoundException;
import per.th.dbox.jdbc.util.MethodRecorder;
import per.th.dbox.jdbc.util.StringUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public
class ShardingDataSource
        extends DataSourceAdpater<DataSource> {

    private Map<String, DataSource> targetDataSources;
    private DataSource defaultDataSource;

    @Override
    public ShardingConnection getConnection() throws SQLException {
        return new ShardingConnection(this);
    }

    @Override
    protected DataSource obtainTargetObject() throws SQLException {
        throw new DataSourceNoFoundException();
    }

    public DataSource getDataSource(String dataSourceId) throws DataSourceNoFoundException {
        if (StringUtils.isEmpty(dataSourceId)) {
            if (defaultDataSource == null) {
                throw new DataSourceNoFoundException();
            } else {
                return defaultDataSource;
            }
        } else {
            DataSource res = targetDataSources.get(dataSourceId);
            if (res == null) {
                throw new DataSourceNoFoundException(dataSourceId);
            } else {
                return res;
            }
        }
    }

    public Connection getConnection(String dataSourceId) throws SQLException {
        return getDataSource(dataSourceId).getConnection();
    }

    public static void main(String[] args) throws SQLException {
        String sql = "select * from user where id = ?";
        ShardingDataSource dataSource = new ShardingDataSource();
        ShardingConnection connection = dataSource.getConnection();
        ShardingPreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, 1);
        ResultSet resultSet = statement.executeQuery();
        System.out.println(resultSet);
    }

}
