package BussinessLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import BussinessLogic.Entities.Usuarios;
import Framework.AppException;

public class LoginWindow extends JFrame implements ActionListener {

    private JLabel epUsernameLabel, epPasswordLabel;
    private JTextField epUsernameField;
    private JPasswordField epPasswordField;
    private JButton epLoginButton;
    private int epIntentos = 0;

    public LoginWindow() {
        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 225); // establece el tamaño de la ventana
        setResizable(false); // deshabilita la capacidad de redimensionar la ventana
        setLocationRelativeTo(null); // centra la ventana en la pantalla

        // Crea los componentes
        epUsernameLabel = new JLabel("Usuario:");
        epPasswordLabel = new JLabel("Contraseña:");
        epUsernameField = new JTextField(20);
        epPasswordField = new JPasswordField(20);
        epLoginButton = new JButton("Iniciar sesión");
        epLoginButton.addActionListener(this); // añade un ActionListener

        // Crea el panel para contener los componentes
        JPanel epPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        epPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // establece los márgenes del epPanel
        epPanel.add(epUsernameLabel);
        epPanel.add(epUsernameField);
        epPanel.add(epPasswordLabel);
        epPanel.add(epPasswordField);
        epPanel.add(new JLabel()); // añade un espacio vacío para ajustar los componentes
        epPanel.add(epLoginButton);

        // Añade el panel a la ventana
        add(epPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Necesariio para encriptar
        Encriptador epEncriptador = new Encriptador();
        // Obtiene el usuario y la contraseña ingresados por el usuario
        String epUsername = epUsernameField.getText();
        String epPassword = String.valueOf(epPasswordField.getPassword());

        // Verifica si el usuario y la contraseña son válidos
        UsuariosBL epUsuarios = new UsuariosBL();
        boolean usuarioEncontrado = false;
        try {
            for (Usuarios user : epUsuarios.epGetAllUsuarios()) {
                if (epUsername.equals(user.getEpUsuario())
                        && epPassword.equals(epEncriptador.epDesencriptar(user.getEpContrasena()))) {
                    JOptionPane.showMessageDialog(this, "Bienvenido " + epUsername + "!");
                    dispose(); // cierra la ventana de inicio de sesión
                    usuarioEncontrado = true;
                    break;
                }
            }
        } catch (AppException e1) {
            e1.printStackTrace();
        } catch (HeadlessException e1) {
            e1.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        // Incrementa el contador de epIntentos si el usuario no es válido
        if (!usuarioEncontrado) {
            epIntentos++;
            if (epIntentos >= 3) {
                JOptionPane.showMessageDialog(this, "Has alcanzado el número máximo de intentos permitidos.");
                dispose(); // cierra la ventana de inicio de sesión
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos. Inténtalo de nuevo.");
            }
        }
    }

}
