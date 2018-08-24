package com.learn.reactive_programming.examples.dataaccess.server;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface RowMapper<T> {
    public T call(ResultSet rs) throws SQLException;
}
