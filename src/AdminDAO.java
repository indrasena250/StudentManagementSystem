import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {
    Connection conn = DBConnection.getConnection();

    public boolean login(String username, String password) {
        try {
            String sql = "SELECT * FROM admins WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // true if found
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
