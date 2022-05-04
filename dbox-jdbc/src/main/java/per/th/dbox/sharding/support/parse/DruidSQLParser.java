package per.th.dbox.sharding.support.parse;

import per.th.dbox.sharding.parse.SQLParseResult;
import per.th.dbox.sharding.parse.SQLParser;

import java.sql.SQLSyntaxErrorException;

public
class DruidSQLParser
        implements SQLParser {

    @Override
    public SQLParseResult parse(String sql) throws SQLSyntaxErrorException {
        return null;
    }

}
