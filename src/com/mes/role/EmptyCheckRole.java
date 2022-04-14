package com.mes.role;

public class EmptyCheckRole implements Role{
    @Override
    public boolean isRolePass(String val) {
        return !val.isEmpty() && val != null && !"".equals(val);
    }
}
