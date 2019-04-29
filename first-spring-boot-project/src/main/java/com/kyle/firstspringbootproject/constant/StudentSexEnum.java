package com.kyle.firstspringbootproject.constant;

import com.kyle.firstspringbootproject.until.BaseEnum;

public enum StudentSexEnum implements BaseEnum<StudentSexEnum, String> {
    //男
    MAN("M"),

    //女
    WOMAN("W");

    private String value;

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private StudentSexEnum(String value){
        setValue(value);
    }
}
