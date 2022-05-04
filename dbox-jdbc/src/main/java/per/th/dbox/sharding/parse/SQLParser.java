package per.th.dbox.sharding.parse;

import java.sql.SQLSyntaxErrorException;

public interface SQLParser {

    SQLParseResult parse(String sql) throws SQLSyntaxErrorException;

}