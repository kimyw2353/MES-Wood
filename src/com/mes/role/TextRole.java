package com.mes.role;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextRole implements Role{

    @Override
    public boolean isRolePass(String val) {
        //특수문자는 불허
        String textPattern = "^(?=.*[!@#$%^&*<>=])";
        Matcher match = Pattern.compile(textPattern).matcher(val);
        return match.find();
    }
}
