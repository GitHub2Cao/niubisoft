package com.softnovo.repository.callback;

import java.sql.SQLException;
import java.sql.Statement;

public interface StatementCallback {
    Object handleStatement(Statement statement) throws SQLException;
}
