package com.apex.user.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

import java.sql.Connection;

@Component
public class DBUtil {

    @Autowired
    private DataSource dataSource;

    public Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }

    public void closeConnection(Connection conn) {
        if (conn != null) {
            DataSourceUtils.releaseConnection(conn, dataSource);
        }
    }
}
