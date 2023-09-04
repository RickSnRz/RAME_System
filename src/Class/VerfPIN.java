package Class;

import Visual.DetIN;
import Visual.Historial;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.awt.Image;
import java.security.SecureRandom;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class VerfPIN {
    public static final String ACCOUNT_SID = "YOU_ACCOUNT_SID";
    public static final String AUTH_TOKEN = "YOU_AUTH_TOKEN";
    
    public void SMSPIN() {
        SecureRandom secureRandom = new SecureRandom();
        int pin = 100000 + secureRandom.nextInt(900000);

        
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
         Message message = Message.creator(
                new PhoneNumber("YOU_NUMBER"),  // Número de teléfono del destinatario
                new PhoneNumber("YOU_NUMBER_TWILIO"), // Número de teléfono de Twilio
                "Hola, Su PIN es: " + pin) // Mensaje de texto a enviar
            .create();
    
        System.out.println(message.getSid());
        gif_check();
        
        String pinIngresado = JOptionPane.showInputDialog(null, "Ingrese el PIN enviado a su teléfono:");
        if (pinIngresado.equals(Integer.toString(pin))) {
            JOptionPane.showMessageDialog(null, "PIN correcto");
            Historial h = new Historial();
            h.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "PIN incorrecto");
        }
    }
    
    public void SMSPIN2() {
        SecureRandom secureRandom = new SecureRandom();
        int pin = 100000 + secureRandom.nextInt(900000);

        
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
         Message message = Message.creator(
                new PhoneNumber("YOU_NUMBER"),  // Número de teléfono del destinatario
                new PhoneNumber("YOU_NUMBER_TWILIO"), // Número de teléfono de Twilio
                "Hola, Su PIN es: " + pin) // Mensaje de texto a enviar
            .create();
    
        System.out.println(message.getSid());
        gif_check();
        
        String pinIngresado = JOptionPane.showInputDialog(null, "Ingrese el PIN enviado a su teléfono:");
        if (pinIngresado.equals(Integer.toString(pin))) {
            JOptionPane.showMessageDialog(null, "PIN correcto");
            DetIN d = new DetIN();
            d.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "PIN incorrecto");
        }
    }
    
    public void gif_check() {
        ImageIcon check_gif = new ImageIcon("src/Imag/200w.gif");
        ImageIcon resizedIcon = new ImageIcon(check_gif.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
        JOptionPane.showMessageDialog(null, "Se envio el PIN, Porfavor espere.", "Information", JOptionPane.PLAIN_MESSAGE, resizedIcon);
        
    }
}
