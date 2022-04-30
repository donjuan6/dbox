package per.th.dbox.jdbc.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * @author th
 * @date 2022/4/30
 * @see
 * @since
 */
public abstract
class ConstantPool<C extends Constant<C>> {

    private final Map<String, C> constants = new ConcurrentHashMap<>();

    public C getOrCreate(String name) {
        return constants.computeIfAbsent(name, this::newConstant);
    }

    public C getOrThrow(String name) {
        C res = constants.get(name);
        if (res == null) {
            throw new IllegalArgumentException(
                    "Not found constant ' " + name + " '");
        }
        return res;
    }

    protected abstract C newConstant(String name);

    public static <C extends Constant<C>>
    ConstantPool<C> withInitial(Function<String, C> func) {
        return new FunctionConstantPool<>(func);
    }

    private static
    class FunctionConstantPool<C extends Constant<C>>
            extends ConstantPool<C> {

        private final Function<String, C> func;

        private FunctionConstantPool(Function<String, C> func) {
            this.func = func;
        }

        @Override
        protected C newConstant(String name) {
            return func.apply(name);
        }

    }

}
