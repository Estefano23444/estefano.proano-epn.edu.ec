package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Framework.AppConfiguration;
import Framework.AppException;

public class UsuariosDAC extends SQLiteDataHelper {
    
    public UsuariosDAC() {
        super(AppConfiguration.getDBPathConnection());
    }

    /**
     * 
     * @return
     * @throws AppException
     */
    public ResultSet epGetAllUsers() throws AppException {
        try {
            String sql = "SELECT * "
                    + "FROM   USUARIOS ";
            return getResultSet(sql);
        } catch (SQLException e) {
            throw new AppException(e, getClass(), "getAllUsers()");
        }
    }

    /**
     * 
     * @param User
     * @return
     * @throws AppException
     */
    public ResultSet epGetUserComper(String User) throws AppException {
        try {
            String sql = "SELECT USUARIOS"
                    + "FROM USUARIOS"
                    + "WHERE USUARIOS LIKE ? ";
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + User.trim() + "%");
            return pstmt.executeQuery();
        } catch (SQLException e) {
            throw new AppException(e, getClass());
        }
    }

}
