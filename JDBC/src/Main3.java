import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Main3 {
    public static void main(String[] args)  throws Exception{

        //load and register driver
        Class.forName("com.mysql.cj.jdbc.Driver"); 

        //establish the connection
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String user = "root";
        String password = "Nitish@1235"; // apna password daalna

        Connection connect = DriverManager.getConnection(url , user , password);

        //create statement
        Statement statement = connect.createStatement();

        //execute query 
        // Retrive the data
        String sql = "SELECT * FROM studentinfo";
        ResultSet rs = statement.executeQuery(sql);
        //process the result
        while(rs.next()){
            // int id = rs.getInt(1);
            System.out.println(rs.getInt(1) + " "+ rs.getString(2) +" "+ rs.getInt(3)+" "+ rs.getString(4));
        }
        //close the resources
        rs.close();
        statement.close();
        connect.close();
    }    
}

