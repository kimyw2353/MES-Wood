package com.mes.dao;

import com.mes.manager.DBManager;
import com.mes.model.Materials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderMaterialsDao extends DBManager {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
}
