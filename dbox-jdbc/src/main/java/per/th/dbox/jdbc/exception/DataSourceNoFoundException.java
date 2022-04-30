package per.th.dbox.jdbc.exception;

import java.sql.SQLException;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public class DataSourceNoFoundException extends SQLException {

    public DataSourceNoFoundException() {
        super("Can not found default DataSource.");
    }

    public DataSourceNoFoundException(String dataSourceId) {
        super("Can not found DataSource '" + dataSourceId + "'.");
    }

}
