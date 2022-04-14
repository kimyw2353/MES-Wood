package com.mes.role;

public class EmptyCheckRole implements Role{
    @Override
    public boolean isRolePass(String val) {
        if(val.isEmpty() || val == null || "".equals(val)){
            return false;
        }else return true;
    }
}
