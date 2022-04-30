package per.th.dbox.jdbc.util;

import java.io.IOException;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public final class ExceptionUtils {

    public static RuntimeException rethrow(Throwable x) {
        return cast(x);
    }

    private static <X extends Throwable> X cast(Throwable x) throws X {
        throw (X) x;
    }

}
