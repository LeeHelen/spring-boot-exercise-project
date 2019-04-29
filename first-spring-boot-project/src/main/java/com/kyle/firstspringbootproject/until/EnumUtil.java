package com.kyle.firstspringbootproject.until;

import java.util.Objects;

/**
 * 枚举类型转换类
 */
public class EnumUtil {
    public static <E extends Enum<E> & BaseEnum> E loopUpEnumValue(Class<E> enumClass, Object value){
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (Objects.toString(e.getValue()).equals(Objects.toString(value))) {
                return e;
            }
        }
        return null;
    }
}
