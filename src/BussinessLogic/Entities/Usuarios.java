package BussinessLogic.Entities;

public class Usuarios {
    private String epUsuario;
    private String epContrasena;

    public Usuarios(String epUsuario, String epContrasena) {
        this.epUsuario = epUsuario;
        this.epContrasena = epContrasena;
    }

    public Usuarios(String string) {
    }

    public String getEpUsuario() {
        return epUsuario;
    }

    public void setEpUsuario(String epUsuario) {
        this.epUsuario = epUsuario;
    }

    public String getEpContrasena() {
        return epContrasena;
    }

    public void setEpContrasena(String epContrasena) {
        this.epContrasena = epContrasena;
    }

}
