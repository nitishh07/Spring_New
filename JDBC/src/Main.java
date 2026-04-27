import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
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
        String sql = "INSERT INTO studentinfo(id , sname, sage, scity) VALUES(2,'Rohit', 18, 'Mumbai')";
        int rowAffected = statement.executeUpdate(sql);
        //process the result
        if(rowAffected == 0){
            System.out.println("Unable to insert data");
        }else{
            System.out.println("Data Inserted Successfully");
        }
        //close the resources
        statement.close();
        connect.close();
    }
}


/*
Connection → database se connection banata hai
DriverManager → connection create karne me help karta hai
Statement → SQL query run karne ke liye
 */

/*
executeUpdate()
👉 Use hota hai:

INSERT
UPDATE
DELETE

📌 Return karta hai:

Kitni rows affect hui
 */