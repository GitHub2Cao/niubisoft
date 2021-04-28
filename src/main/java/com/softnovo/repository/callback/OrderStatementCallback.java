package com.softnovo.repository.callback;

import com.softnovo.domain.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderStatementCallback implements StatementCallback {
    private String sql;

    public OrderStatementCallback(String sql) {
        this.sql = sql;
    }

    public OrderStatementCallback() {}

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Object handleStatement(Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery(sql);
        List<Order> orders = new ArrayList<>();
        while (rs.next()) {
            Order order = new Order(rs.getLong("id"), rs.getString("order_number"),
                    rs.getString("delivery_address"));
            orders.add(order);
        }
        return orders;
    }
}
