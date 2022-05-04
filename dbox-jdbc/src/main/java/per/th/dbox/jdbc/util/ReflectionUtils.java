package per.th.dbox.jdbc.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public final class ReflectionUtils {

    public static <T> T newProxy(Class<T> clazz, InvocationHandler handler) {
        return newProxy(clazz.getClassLoader(), clazz, handler);
    }

    public static <T> T newProxy(ClassLoader classLoader, Class<T> clazz, InvocationHandler handler) {
        return (T) Proxy.newProxyInstance(classLoader, new Class<?>[]{ clazz }, handler);
    }

}
