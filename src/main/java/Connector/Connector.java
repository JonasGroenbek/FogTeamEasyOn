/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
/**
 *
 * @author stgre
 */

public class Connector {
    

    private DataSource dataSource;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public Connector(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        return connection;
    }

    public void open() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = dataSource.getConnection();
        }
    }

    public Statement getStatement() throws SQLException {
        return connection.createStatement();
    }

    public void close() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }

        if (statement != null) {
            statement.close();
        }

        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }

    public ResultSet query(String sql) throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);

        return resultSet;
    }

    public void update(String sql) throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate(sql);
    }
    public PreparedStatement preparedStatement(String sql) throws SQLException{
        return connection.prepareStatement(sql);
    }
}

