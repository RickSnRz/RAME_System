/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Rick
 */
public class ConnectionPool {
    private final String DB="YOU_DATABASE";
    private final String URL="jdbc:mysql://localhost:3306/"+DB;
    private final String USER="YOU_USER";
    private final String PASS="YOU_PASSWORD";
    
    private static ConnectionPool dataSource;
    private BasicDataSource basicDataSource=null;
    
    private ConnectionPool(){
        
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(URL);
                
        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxTotal(50);
        basicDataSource.setMaxWaitMillis(-1);
    }
    
    public static ConnectionPool getInstance(){
        if (dataSource == null){
            dataSource = new ConnectionPool();
            return dataSource;
        } else {
            return dataSource;
        }
    }
    
    public Connection getConnection() throws SQLException{
        return this.basicDataSource.getConnection();
    }
    
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
