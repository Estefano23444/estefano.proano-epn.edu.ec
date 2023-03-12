package BussinessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import BussinessLogic.Entities.Usuarios;
import DataAccess.UsuariosDAC;
import Framework.AppException;


public class UsuariosBL {
    
    public List<Usuarios>getAllParroquia() throws AppException{
        try {
            UsuariosDAC    usuariosDAC    = new UsuariosDAC();
            List<Usuarios> lstUsuarios    = new ArrayList<Usuarios>();

            ResultSet rs =  usuariosDAC.getAllParroquia();
            while(rs.next())    {
                Usuarios us = new Usuarios(rs.getString("USUARIO"),  rs.getString("CONTRASENA"));                
                lstUsuarios.add(us);
            }
            return lstUsuarios; 
        } catch (SQLException e) {
            throw new AppException(e, getClass(),"getAllParroquia");
        }
    }
}