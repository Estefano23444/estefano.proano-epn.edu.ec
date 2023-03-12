/**
 * @Author      : Estefano Proaño
 * @Copyright   : Estefano Proaño
 * Date         : 12-03-2023
 * @Version     : 1.0
 */
//import BussinessLogic.LoginWindow;
import BussinessLogic.*;

public class App {

    // Declaracion de variables globales y del patron de expresion regular
    // correspondiente
    static final String EPNOMBRE_COMPLETO = "Estefano Mateo Proaño Ingavelez";
    static final Integer EPCEDULA = 1724156219;
    /**
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        LoginWindow epWindow = new LoginWindow();
        epWindow.setVisible(true); // muestra la ventana

    }
}
