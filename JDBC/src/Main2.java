import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main2 {
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
        String sql = "UPDATE studentinfo set sage=24 where id=2";
        int rowAffected = statement.executeUpdate(sql);
        //process the result
        if(rowAffected == 0){
            System.out.println("Unable to update");
        }else{
            System.out.println("Update successfull");
        }
        //close the resources
        statement.close();
        connect.close();
    }
    
}
