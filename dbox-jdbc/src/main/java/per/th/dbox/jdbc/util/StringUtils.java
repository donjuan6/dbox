package per.th.dbox.jdbc.util;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public final class StringUtils {

    public static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public static boolean hasText(String text) {
        return text != null && text.trim().length() > 0;
    }

}
