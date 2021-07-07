package siit.db;

import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class DbMain {

    public static void main(String[] args) {

        try (
            Connection connection = getPostGresSqlDataSourceConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customers")
        )
        {
            while(rs.next()){
                System.out.println("customer { "+ rs.getInt("ID") + ", " + rs.getString("name") + " }");
              }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl("jdbc:h2:file:./db/store");
        dataSource.setUser("sa");
        dataSource.setPassword("");

        return dataSource;
    }
    public static Connection getPostGresSqlDataSourceConnection()throws SQLException{
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123456");
    }

}
