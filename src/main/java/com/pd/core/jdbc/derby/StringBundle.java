package com.pd.core.jdbc.derby;

public interface StringBundle {

    String JDBC_EMBEDDED_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    String DB_URL = "jdbc:derby://localhost:1527/derbyDB;create=true";

    String CREATE_TABLE_SQL = "create table restaurants(id integer, name varchar(20), city varchar(50))";
}
