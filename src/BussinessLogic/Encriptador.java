package BussinessLogic;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Encriptador {

    private static final String EPALGORITMO = "AES/CBC/PKCS5PADDING";
    private static final byte[] EPIV = "0123456789abcdef".getBytes();
    private static final String EPLLAVE_SECRETA = "1234567890123456"; // Llave de 16 bytes
    /**
     * 
     * @param texto
     * @return
     * @throws Exception
     */
    public static String epEncriptar(String texto) throws Exception {
        Cipher epCipher = Cipher.getInstance(EPALGORITMO);
        SecretKeySpec epLlave = new SecretKeySpec(EPLLAVE_SECRETA.getBytes(), "AES");
        IvParameterSpec iv = new IvParameterSpec(EPIV);
        epCipher.init(Cipher.ENCRYPT_MODE, epLlave, iv);
        byte[] epTextoEnBytes = texto.getBytes("UTF-8");
        byte[] epTextoEncriptado = epCipher.doFinal(epTextoEnBytes);
        return Base64.getEncoder().encodeToString(epTextoEncriptado);
    }

    /**
     * 
     * @param textoEncriptado
     * @return
     * @throws Exception
     */
    public String epDesencriptar(String textoEncriptado) throws Exception {
        Cipher epCipher = Cipher.getInstance(EPALGORITMO);
        SecretKeySpec llave = new SecretKeySpec(EPLLAVE_SECRETA.getBytes(), "AES");
        IvParameterSpec iv = new IvParameterSpec(EPIV);
        epCipher.init(Cipher.DECRYPT_MODE, llave, iv);
        byte[] epTextoEnBytes = Base64.getDecoder().decode(textoEncriptado);
        byte[] epTextoDesencriptado = epCipher.doFinal(epTextoEnBytes);
        return new String(epTextoDesencriptado, "UTF-8");
    }
}
