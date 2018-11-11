package com.lypgod.test.tij4.practices.Ch15_Generics.Practice22;

import java.lang.reflect.InvocationTargetException;

public class ClassTypeCreator<T> {
    Class<?> kind;

    public ClassTypeCreator(Class<?> kind) {
        this.kind = kind;
    }

    public Object createNew(String typename) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return Class.forName(typename).newInstance();
    }

    /**
     * To create instance of typename with constructors taking arguments args:
     */
    public Object createNew(String typename, Object... args) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        switch (args.length) {
            case 1:
                return Class.forName(typename).getConstructor(args[0].getClass()).newInstance(args[0]);
            case 2:
                return Class.forName(typename).getConstructor(args[0].getClass(), args[1].getClass()).
                        newInstance(args[0], args[1]);
        }
        return null;
    }
}
