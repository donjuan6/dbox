package per.th.dbox.jdbc.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invocation {

    private final Object target;
    private final Method method;
    private final Object[] arguments;

    public Invocation(Object target, Method method, Object[] arguments) {
        this.target = target;
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

    public Object getTarget() {
        return target;
    }

    public Method getMethod() {
        return method;
    }

    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public String toString() {
        return target.getClass() + ":" + method.toString();
    }

}
