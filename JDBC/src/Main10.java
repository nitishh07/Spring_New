import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// DELETE using PreparedStatement
public class Main10 {
    public static void main(String[] args) {
        Connection connect = null;
        PreparedStatement pstmnt = null;
        ResultSet rs = null;

        try {
            connect = Main6.getConnection();

            String sql = "SELECT id , sname , sage , scity FROM studentinfo WHERE id=?";
            pstmnt = connect.prepareStatement(sql);

            Scanner sc = new Scanner(System.in);
            System.out.println("Kindly enter your id for which Data to be Retrived :");
            Integer id = sc.nextInt();

            pstmnt.setInt(1, id);

            rs = pstmnt.executeQuery();
            if(rs.next()){
                Integer sid = rs.getInt(1);
                String name = rs.getString(2);
                Integer sage = rs.getInt(3);
                String scity = rs.getString(4);
                
                System.out.println(sid + " " + name + " " + sage + " " + scity + " ");

            }else{
                System.out.println("No record found !");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
