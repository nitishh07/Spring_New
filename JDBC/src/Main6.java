// Yha se baki class me use kr skte hai baar baar create ni krna pdega

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main6 {
    static{
        try {
        //load and register driver
        Class.forName("com.mysql.cj.jdbc.Driver");     
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception{
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String user = "root";
        String password = "Nitish@1235"; // apna password daalna

        return DriverManager.getConnection(url , user , password);
    }

    public static void closeConnection(Connection connect, Statement statement) throws SQLException{
           statement.close();
           connect.close();
    }
}
