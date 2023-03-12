package BussinessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BussinessLogic.Entities.Usuarios;
import DataAccess.UsuariosDAC;
import Framework.AppException;

public class UsuariosBL {
    /**
     * 
     * @return
     * @throws AppException
     */
    public List<Usuarios> epGetAllUsuarios() throws AppException {
        try {
            UsuariosDAC epUsuariosDAC = new UsuariosDAC();
            List<Usuarios> epLstUsuarios = new ArrayList<Usuarios>();

            ResultSet rs = epUsuariosDAC.epGetAllUsers();
            while (rs.next()) {
                Usuarios us = new Usuarios(rs.getString("USUARIOS"), rs.getString("CONTRASENA"));
                epLstUsuarios.add(us);
            }
            return epLstUsuarios;
        } catch (SQLException e) {
            throw new AppException(e, getClass(), "getAllUsers");
        }
    }
}