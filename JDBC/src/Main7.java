import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
// Prepared Statment
public class Main7 {
    public static void main(String[] args)  throws Exception{
        Connection connect = null;
        Statement statement = null;
        PreparedStatement pstmnt = null;
        try {
        //load and register driver
        Class.forName("com.mysql.cj.jdbc.Driver"); 

        //establish the connection
        connect = Main6.getConnection();

        //create statement
        // statement = connect.createStatement();

        //execute query
        String query = "INSERT INTO studentinfo(id , sname, sage, scity) VALUES(? , ? , ? , ?)";
        pstmnt = connect.prepareStatement(query);

        System.out.println("Please enter the following details to be stored in DB ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your id : ");
        Integer id = sc.nextInt();

        System.out.println("Enter your name : ");
        String name = sc.next();

        System.out.println("Enter your age : ");
        Integer age = sc.nextInt();

        System.out.println("Enter your city : ");
        String city = sc.next();


        pstmnt.setInt(1 ,id);
        pstmnt.setString(2, name);
        pstmnt.setInt(3, age);
        pstmnt.setString(4, city);

        int rowAffected = pstmnt.executeUpdate();
        //process the result
            if(rowAffected == 0){
                System.out.println("Operation failed");
            }else{
                System.out.println("Operation successfull");
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
            try {
                if(pstmnt != null) pstmnt.close();
                if(connect != null) connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
