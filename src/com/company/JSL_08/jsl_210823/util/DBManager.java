package com.company.JSL_08.jsl_210823.util;

import java.sql.Connection;

public interface DBManager {
    Connection getConnection();
    Connection getConnection(String id, String pw);
    abstract Connection getConnection(String db, String id, String pw);
}
