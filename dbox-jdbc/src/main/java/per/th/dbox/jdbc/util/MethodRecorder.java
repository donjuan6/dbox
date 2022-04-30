package per.th.dbox.jdbc.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public final
class MethodRecorder<T>
        implements InvocationHandler {

    private final T proxy;
    private final Class<T> proxyInterface;
    private final List<Invocation> records;
    private final ReturnValueHolder holder;

    private MethodRecorder(Class<T> clazz, ReturnValueHolder holder, boolean sync) {
        this.proxy = newProxy(clazz.getClassLoader(), clazz);
        this.proxyInterface = clazz;
        this.records = sync ? new Vector<>() : new ArrayList<>();
        this.holder = holder;
    }

    private <T> T newProxy(ClassLoader classLoader, Class<T> clazz) {
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{clazz}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> type = method.getReturnType();
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, args);
        }
        if (type == void.class) {
            records.add(new Invocation(proxy, method, args));
            return null;
        }
        if (type == proxyInterface) {
            records.add(new Invocation(proxy, method, args));
            return proxy;
        }
        if (holder == null) {
            throw new NoSuchMethodException(method.toString());
        } else {
            records.add(new Invocation(proxy, method, args));
            return holder.getReturnValue(method.getReturnType());
        }
    }

    public T getProxyInstance() {
        return proxy;
    }

    public void reset() {
        this.records.clear();
    }

    public void replay(T target) throws Throwable {
        for (Invocation record : this.records) {
            record.invoke(target);
        }
    }

    @Override
    public String toString() {
        return "MethodRecorder: " + proxyInterface.getName();
    }

    interface ReturnValueHolder {
        Object getReturnValue(Class<?> clazz);
    }

    static class Invocation {

        final Object proxy;
        final Method method;
        final Object[] arguments;

        Invocation(Object proxy, Method method, Object[] arguments) {
            this.proxy = proxy;
            this.method = method;
            this.arguments = arguments;
        }

        Object invoke(Object target) throws Throwable {
            try {
                return method.invoke(target, arguments);
            } catch (InvocationTargetException e) {
                if (e.getCause() != null) {
                    throw e.getCause();
                } else {
                    throw e;
                }
            }
        }

        @Override
        public String toString() {
            return proxy.getClass() + ":" + method.toString();
        }
    }

    public static <T> MethodRecorder<T> get(Class<T> clazz) {
        return new MethodRecorder<>(clazz, type -> null, false);
    }

}
