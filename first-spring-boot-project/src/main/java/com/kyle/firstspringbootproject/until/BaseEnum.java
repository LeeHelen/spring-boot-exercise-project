package com.kyle.firstspringbootproject.until;

/**
 * 枚举通用行为，规范枚举的实现。
 */
public interface BaseEnum<E extends Enum<?>, T> {
    /**
     * 获取枚举的值
     * @return 枚举的值
     */
    T getValue();
}
