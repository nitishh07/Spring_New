import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Batch Update
public class Main11 {
    public static void main(String[] args) {
        Connection connect = null;
        PreparedStatement pstmnt = null;
        ResultSet rs = null;

        try {
            connect = Main6.getConnection();

            String sql = "UPDATE studentinfo SET sage=? WHERE id=?";
            pstmnt = connect.prepareStatement(sql);

// pstmnt.setInt(1, 20); // age = 20
// pstmnt.setInt(2, 1);  // id = 1
//UPDATE studentinfo SET age = 20 WHERE id = 1;
            pstmnt.setInt(1, 20);
            pstmnt.setInt(2, 1);
            pstmnt.addBatch();
            pstmnt.setInt(1, 24);
            pstmnt.setInt(2, 3);
            pstmnt.addBatch();
            pstmnt.setInt(1, 14);
            pstmnt.setInt(2, 2);
            pstmnt.addBatch();           

            pstmnt.executeBatch();
            System.out.println("Check the db table to see the result ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
