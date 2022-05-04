package per.th.dbox.jdbc.adpater.param;

import per.th.dbox.jdbc.util.Invocation;
import per.th.dbox.jdbc.util.ReflectionUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public
class JdbcParameters
        implements InvocationHandler {

    private final PreparedStatement proxy;
    private final List<Invocation> invocations;

    public JdbcParameters() {
        this.proxy = ReflectionUtils.newProxy(PreparedStatement.class, this);
        this.invocations = new ArrayList<>();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        assertSetParameterMethod(method);
        int index = getParameterIndex(args);
        int length = invocations.size();
        if (length < index) {
            for (int i = length; i < index; i++) {
                invocations.add(null);
            }
            invocations.add(new Invocation(proxy, method, args));
        } else {
            invocations.set(index, new Invocation(proxy, method, args));
        }
        return null;
    }

    private void assertSetParameterMethod(Method m) {
        if (!isSetParameterMethod(m)) {
            throw new UnsupportedOperationException("Unsupport method: " + m);
        }
    }

    public Object getParameterObject(int index) {
        Invocation invocation = invocations.get(index);
        Object[] args = invocation.getArguments();
        if (args.length != 2) {
            throw new NoSuchElementException();
        }
        return args[2];
    }

    public PreparedStatement getProxy() {
        return proxy;
    }

    public Invocation[] getInvocations() {
        return invocations.toArray(new Invocation[0]);
    }

    private boolean isSetParameterMethod(Method m) {
        return m.getName().startsWith("set")
                && m.getParameterCount() > 1
                && m.getParameterTypes()[0] == int.class;
    }

    private int getParameterIndex(Object[] args) {
        return (Integer) args[0];
    }

}
