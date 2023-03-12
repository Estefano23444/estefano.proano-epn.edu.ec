package BussinessLogic;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Encriptador {

    private static final String ALGORITMO = "AES/CBC/PKCS5PADDING";
    private static final byte[] IV = "0123456789abcdef".getBytes();
    private static final String LLAVE_SECRETA = "1234567890123456"; // Llave de 16 bytes

    public static String encriptar(String texto) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        SecretKeySpec llave = new SecretKeySpec(LLAVE_SECRETA.getBytes(), "AES");
        IvParameterSpec iv = new IvParameterSpec(IV);
        cipher.init(Cipher.ENCRYPT_MODE, llave, iv);
        byte[] textoEnBytes = texto.getBytes("UTF-8");
        byte[] textoEncriptado = cipher.doFinal(textoEnBytes);
        return Base64.getEncoder().encodeToString(textoEncriptado);
    }

    public static String desencriptar(String textoEncriptado) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        SecretKeySpec llave = new SecretKeySpec(LLAVE_SECRETA.getBytes(), "AES");
        IvParameterSpec iv = new IvParameterSpec(IV);
        cipher.init(Cipher.DECRYPT_MODE, llave, iv);
        byte[] textoEnBytes = Base64.getDecoder().decode(textoEncriptado);
        byte[] textoDesencriptado = cipher.doFinal(textoEnBytes);
        return new String(textoDesencriptado, "UTF-8");
    }
}
