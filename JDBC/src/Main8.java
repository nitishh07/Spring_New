import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// Update using PreparedStatemnt
public class Main8 {
    public static void main(String[] args) {
        Connection connect = null;
        PreparedStatement pstmnt = null;
        try {
            connect = Main6.getConnection();

            String sql = "UPDATE studentinfo SET sage=? WHERE id=?";
            pstmnt = connect.prepareStatement(sql);

            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the info that needs to be updated ");
            System.out.println("Kindly enter your id : ");
            Integer id = sc.nextInt();
            System.out.println("Please enter age to be updated : ");
            Integer age = sc.nextInt();

            pstmnt.setInt(1, age);
            pstmnt.setInt(2, id);

            int rowAffected = pstmnt.executeUpdate();

            //process the result
            if(rowAffected == 0){
                System.out.println("Unable to update the data");
            }else{
                System.out.println("Data Updated Sucessfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
