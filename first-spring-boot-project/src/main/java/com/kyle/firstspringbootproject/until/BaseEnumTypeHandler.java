package com.kyle.firstspringbootproject.until;

import com.kyle.firstspringbootproject.constant.StudentSexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 参考 http://blog.csdn.net/fighterandknight/article/details/51520595
 * https://segmentfault.com/a/1190000010755321
 * http://www.cnblogs.com/qnight/p/8997496.html
 * https://my.oschina.net/SEyanlei/blog/188919
 * 进行对本地项目的优化
 * <p>
 * 解决 Mybatis 中枚举的问题，
 * 获取 ResultSet 的值都是获取字符串的，然后比较字符串，以便通用。
 *
 */
@MappedTypes(value = {StudentSexEnum.class})
//@MappedJdbcTypes(value = {JdbcType.CHAR})
public class BaseEnumTypeHandler<E extends Enum<E> & BaseEnum> extends BaseTypeHandler<E> {
    /**
     * 枚举的class
     */
    private Class<E> enumClass;

    /**
     * 一定要有默认的构造函数，不然抛出 not found method 异常
     */
    public BaseEnumTypeHandler() {
    }

    /**
     * 设置配置文件设置的转换类以及枚举类内容，供其他方法更便捷高效的实现
     *
     * @param enumClass 配置文件中设置的转换类
     */
    public BaseEnumTypeHandler(Class<E> enumClass) {
        this.enumClass = enumClass;
    }

    /**
     * 用于定义设置参数时，该如何把Java类型的参数转换为对应的数据库类型
     * @param ps
     * @param i
     * @param parameter
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter,
                                    JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter.getValue(), jdbcType.TYPE_CODE);
    }

    /**
     * 用于定义通过字段名称获取字段数据时，如何把数据库类型转换为对应的Java类型
     * @param rs
     * @param columnName
     * @return
     * @throws SQLException
     */
    @Override
    public E getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        String value = rs.getString(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return EnumUtil.loopUpEnumValue(enumClass, value);
        }
    }

    /**
     * 用于定义通过字段索引获取字段数据时，如何把数据库类型转换为对应的Java类型
     * @param rs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public E getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        String value = rs.getString(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            return EnumUtil.loopUpEnumValue(enumClass, value);
        }
    }

    /**
     * 用定义调用存储过程后，如何把数据库类型转换为对应的Java类型
     * @param cs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        String value = cs.getString(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            return EnumUtil.loopUpEnumValue(enumClass, value);
        }
    }
}
