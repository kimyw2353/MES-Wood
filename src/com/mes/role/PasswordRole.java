package com.mes.role;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordRole implements Role {
    public boolean isRolePass(String val){
        // 알파벳 소문자, 대문자 특수문자(!@#$%^&*()-) 숫자 4가지 모두포함해야 함.
        String pwPattern = "^(?=.*[!@#$%^&*()-])(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,16}$";
        Matcher match = Pattern.compile(pwPattern).matcher(val);
        return match.find();
    }
}
