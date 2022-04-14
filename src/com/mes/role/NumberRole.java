package com.mes.role;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberRole implements Role {
    @Override
    public boolean isRolePass(String val) {

        //        숫자 정규식
        final String idPattern = "^[0-9]{0,9}$"; //0~9의 숫자와 9자리 이하의 숫자

        Matcher match = Pattern.compile(idPattern).matcher(val);
        return match.find();
    }

}
