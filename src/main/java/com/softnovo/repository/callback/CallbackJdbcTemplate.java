package com.softnovo.repository.callback;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository("callbackJdbcTemplate")
public class CallbackJdbcTemplate {
    @Resource
    private DataSource dataSource;

    public final Object execute(StatementCallback callback) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            Object object = callback.handleStatement(statement);
            return object;
        } catch (SQLException e) {
            System.out.print(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return  null;
    }

    public Object queryOrder(final String sql) {
        return this.execute(new OrderStatementCallback(sql));
    }
}
