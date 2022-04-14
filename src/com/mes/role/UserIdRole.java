package com.mes.role;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserIdRole implements Role {
    public boolean isRolePass(String val){
        String idPattern = "^(?=.*[!@#$%^&*()-]).{0,16}$";
        Matcher match = Pattern.compile(idPattern).matcher(val);
        return !match.find();
    }
}
