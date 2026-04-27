import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main5 {
    public static void main(String[] args)  throws Exception{
        Connection connect = null;
        Statement statement = null;
        try {
        //load and register driver
        Class.forName("com.mysql.cj.jdbc.Driver"); 

        //establish the connection
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String user = "root";
        String password = "Nitish@1235"; // apna password daalna

        connect = DriverManager.getConnection(url , user , password);

        //create statement
        statement = connect.createStatement();

        //execute query 
        String sql = "Update studentinfo set sage = 16 where id = 1";
        boolean status = statement.execute(sql);
        //process the result
        if(status){
            //select 
            ResultSet rs = statement.getResultSet();
            while(rs.next()){
            System.out.println(rs.getInt(1) + " "+ rs.getString(2) +" "+ rs.getInt(3)+" "+ rs.getString(4));
            }
        }else{
            //insert, update , delete
            int rows = statement.getUpdateCount();
            if(rows == 0){
                System.out.println("Operation failed");
            }else{
                System.out.println("Operation successfull");
            }
        }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
        //close the resources
        try {
        //    statement.close();
        //    connect.close();
        Main6.closeConnection(connect, statement);
        
        } catch (Exception e) {
            e.printStackTrace();
        }

        }
    }
    
}
