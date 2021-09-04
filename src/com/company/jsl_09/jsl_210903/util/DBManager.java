package com.company.jsl_09.jsl_210903.util;

import java.sql.Connection;

public interface DBManager {
    Connection getConnection();
    Connection getConnection(String id, String pw);
    abstract Connection getConnection(String db, String id, String pw);
}
