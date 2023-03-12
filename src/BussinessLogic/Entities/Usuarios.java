package BussinessLogic.Entities;

public class Usuarios {
    private String epUsuario;
    private String epContrasena;

    public Usuarios(String epUsuario, String epContrasena) {
        this.epUsuario = epUsuario;
        this.epContrasena = epContrasena;
    }

    /**
     * 
     * @param string
     */
    public Usuarios(String string) {
    }

    /**
     * 
     * @return
     */
    public String getEpUsuario() {
        return epUsuario;
    }

    /**
     * 
     * @param epUsuario
     */
    public void setEpUsuario(String epUsuario) {
        this.epUsuario = epUsuario;
    }

    /**
     * 
     * @return
     */
    public String getEpContrasena() {
        return epContrasena;
    }

    /**
     * 
     * @param epContrasena
     */
    public void setEpContrasena(String epContrasena) {
        this.epContrasena = epContrasena;
    }

}
