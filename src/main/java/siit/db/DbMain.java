package siit.db;

import org.h2.jdbcx.JdbcDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbMain {

    public static void main(String[] args) {

        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl("jdbc:h2:file:./db/store");
        dataSource.setUser("sa");
        dataSource.setPassword("");

        try (
            Connection connection = dataSource.getConnection();
            Statement stmt = connection.createStatement()
            ) {

            //TODO interact with DB

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
