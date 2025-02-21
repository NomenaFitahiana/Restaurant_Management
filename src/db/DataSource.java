package db;

import java.sql.*;

public class DataSource {
    private final int defaultPort = 5432;
    private final String USER = System.getenv("DB_USER");
    private final String PSW = System.getenv("DB_PASSWORD");
    private String jdbcUrl;

    public DataSource() {
        String HOST = System.getenv("DB_HOST");
        String DB = System.getenv("DB_NAME");
        jdbcUrl = "jdbc:postgresql://" + HOST + ":" + defaultPort + "/" + DB;
    }

    public Connection getConnection(){
        try{
            return DriverManager.getConnection(jdbcUrl, USER, PSW);
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
