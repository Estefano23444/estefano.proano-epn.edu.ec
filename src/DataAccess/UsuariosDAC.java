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
//--------------------------------------------------------------------------------------
    /**
     * 
     * @return
     * @throws AppException
     */
    public ResultSet getAllUsers() throws AppException{
            try {
                String sql = "SELECT * "
                            +"FROM   USUARIOS ";
                return getResultSet(sql);
            } 
            catch (SQLException e) {
                throw new AppException(e, getClass(), "getAllUsers()");
            }
        }


    public ResultSet getUserComper(String User) throws AppException { 
        try {
            String sql = "SELECT USUARIOS"
                        +"FROM LOCALIDAD "
                        +"WHERE USUARIOS LIKE ? ";    
            Connection conn = getConnection();
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + User.trim() + "%");
            //System.out.println(sql);
            return pstmt.executeQuery();
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass());
        }
    }


}
