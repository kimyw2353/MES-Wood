package com.mes.role;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateRole implements Role{

    @Override
    public boolean isRolePass(String val) {
        Pattern pattern =  Pattern.compile("^((19|20)\\d\\d)?([-])?(0[1-9]|1[012])([-])?(0[1-9]|[12][0-9]|3[01])$");
        Matcher matcher = pattern.matcher(val);
        return matcher.find();
    }

    public boolean isRolePass(String val, String val2) {
        Pattern pattern =  Pattern.compile("^((19|20)\\d\\d)?([-])?(0[1-9]|1[012])([-])?(0[1-9]|[12][0-9]|3[01])$");
        Matcher matcher = pattern.matcher(val);
        Matcher matcher2 = pattern.matcher(val2);

        return matcher.find() && matcher2.find() ? true : false;
    }
}
