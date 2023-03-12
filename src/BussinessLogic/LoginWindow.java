package BussinessLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import BussinessLogic.Entities.Usuarios;
import Framework.AppException;

public class LoginWindow extends JFrame implements ActionListener {

    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private int intentos = 0;

    public LoginWindow() {
        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 225); // establece el tamaño de la ventana
        setResizable(false); // deshabilita la capacidad de redimensionar la ventana
        setLocationRelativeTo(null); // centra la ventana en la pantalla

        // Crea los componentes
        usernameLabel = new JLabel("Usuario:");
        passwordLabel = new JLabel("Contraseña:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Iniciar sesión");
        loginButton.addActionListener(this); // añade un ActionListener

        // Crea el panel para contener los componentes
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // establece los márgenes del panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // añade un espacio vacío para ajustar los componentes
        panel.add(loginButton);

        // Añade el panel a la ventana
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Necesariio para encriptar
        Encriptador encriptador = new Encriptador();
        // Obtiene el usuario y la contraseña ingresados por el usuario
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

        // Verifica si el usuario y la contraseña son válidos
        UsuariosBL usuarios = new UsuariosBL();
        boolean usuarioEncontrado = false;
        try {
            for (Usuarios user : usuarios.getAllUsuarios()) {
                if (username.equals(user.getEpUsuario())
                        && password.equals(encriptador.desencriptar(user.getEpContrasena()))) {
                    JOptionPane.showMessageDialog(this, "Bienvenido " + username + "!");
                    dispose(); // cierra la ventana de inicio de sesión
                    usuarioEncontrado = true;
                    break;
                }
            }
        } catch (AppException e1) {
            e1.printStackTrace();
        } catch (HeadlessException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // Incrementa el contador de intentos si el usuario no es válido
        if (!usuarioEncontrado) {
            intentos++;
            if (intentos >= 3) {
                JOptionPane.showMessageDialog(this, "Has alcanzado el número máximo de intentos permitidos.");
                dispose(); // cierra la ventana de inicio de sesión
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos. Inténtalo de nuevo.");
            }
        }
    }

}
