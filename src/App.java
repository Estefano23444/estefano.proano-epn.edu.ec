//import BussinessLogic.LoginWindow;
import BussinessLogic.Entities.Usuarios;
import Framework.AppException;
import BussinessLogic.*;

public class App {
    public static void main(String[] args) throws AppException {
        // LoginWindow window = new LoginWindow();
        // window.setVisible(true); // muestra la ventana

        UsuariosBL usuarios = new UsuariosBL();
        for (Usuarios user : usuarios.getAllUsuarios()) {
            System.out.print    ("|"+user.getEpUsuario()  + "\t\t|");
            System.out.println  (user.getEpContrasena() + "\t\t|");
        }
    }
}
