import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// DELETE using PreparedStatement
public class Main9 {
    public static void main(String[] args) {
        Connection connect = null;
        PreparedStatement pstmnt = null;
        try {
            connect = Main6.getConnection();

            String sql = "DELETE FROM studentinfo WHERE id=?";
            pstmnt = connect.prepareStatement(sql);

            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the info that needs to be deleted ");
            System.out.println("Kindly enter your id : ");
            Integer id = sc.nextInt();

            pstmnt.setInt(1, id);

            int rowAffected = pstmnt.executeUpdate();

            //process the result
            if(rowAffected == 0){
                System.out.println("Unable to delete the data");
            }else{
                System.out.println("Data Deleted Sucessfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
