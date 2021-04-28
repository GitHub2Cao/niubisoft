package com.softnovo.repository;

import com.softnovo.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("orderRawJdbcRepository")
public class OrderRawJdbcRepository implements OrderRepository {
    @Autowired
    private DataSource dataSource;

    @Override
    public Order addOrder(Order order) {
        return null;
    }

    @Override
    public Order getOrderById(Long orderId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("select id, order_number, delivery_address from `order` where id=?");
            statement.setLong(1, orderId);
            resultSet = statement.executeQuery();
            Order order = null;
            if (resultSet.next()) {
                order = new Order(resultSet.getLong("id"), resultSet.getString("order_number"), resultSet.getString("delivery_address"));
            }
            return order;
        } catch (SQLException e) {
            System.out.print(e);
        } catch (Throwable e) {
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
        return null;
    }

    @Override
    public Order getOrderDetailByOrderNumber(String orderNumber) {
        return null;
    }
}
