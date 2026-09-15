package dal;

import java.sql.*;

public class UsersDAO extends DBContext{
    private final String LOGIN_INFO = "select * from Users where username = ? AND password = ?";
    
    public boolean login(String username, String password) {
        try (Connection c = getConnection();
              PreparedStatement stm = c.prepareStatement(LOGIN_INFO)){
            
            stm.setString(1, username);
            stm.setString(2, password);
            
            try (ResultSet rs = stm.executeQuery()){
                if (rs.next()) {
                    return true;
                }
            } catch (SQLException sQLException) {
                sQLException.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("Database connection or query failed in UsersDAO.login:");
            e.printStackTrace();
        }
        return false;
        
      
    }
}
