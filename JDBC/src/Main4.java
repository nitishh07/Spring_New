import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main4 {
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
        String sql = "DELETE FROM studentinfo where id = 2";
        int rowsAffected = statement.executeUpdate(sql);
        //process the result
        if(rowsAffected == 0){
            System.out.println("Failed to delete the record");
        }else{
            System.out.println("Record deleted successfully!");
        }
        //close the resources
        statement.close();
        connect.close();
    }
    
}

