package com.pd.core.jdbc.derby;

public interface StringBundle {

    String JDBC_EMBEDDED_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    String JDBC_CLIENT_DRIVER = "org.apache.derby.jdbc.ClientDriver";

    String DB_URL = "jdbc:derby://localhost:1527/derbyDB;create=true";
    String DB_URL_EMBEDDED = "jdbc:derby:memory:codejava/webdb;create=true";

    String CREATE_TABLE_SQL = "create table restaurants(id integer, name varchar(20), city varchar(50))";

    String SQL_CREATE_TABLE_SQL_EatingJoints = "create table EatingJoints(MAP_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), name varchar(20), city varchar(50))";
    String SQL_DROP_TABLE_SQL_EatingJoints = "drop table EatingJoints";
    String SQL_SELECT_ALL_FROM_EATING_JOINTS = "select * from EatingJoints";
    String SQL_ALTER_EATING_JOINTS = "ALTER TABLE EatingJoints ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY	 (START WITH 1, INCREMENT BY 1)";
    String SQL_PREPARED_STATEMENT_INSERT = "insert into EatingJoints(name, city) values (?,?)";
    /*
     * CREATE TABLE MAPS ( MAP_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY
     * (START WITH 1, INCREMENT BY 1), MAP_NAME VARCHAR(24) NOT NULL, REGION
     * VARCHAR(26), AREA DECIMAL(8,4) NOT NULL, PHOTO_FORMAT VARCHAR(26) NOT
     * NULL, PICTURE BLOB(102400), UNIQUE (MAP_ID, MAP_NAME) )
     */
}
