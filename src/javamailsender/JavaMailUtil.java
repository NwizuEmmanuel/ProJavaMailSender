/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamailsender;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Onyekachukwu
 */
public class JavaMailUtil {
   public static void SendEmail(String senderAddress,String senderPassword, String receiverAddress,String MailSub,String mssg){
       System.out.println("Preparing to send message");
       
       // declaring properties
       Properties properties = new Properties();
       
       properties.put("mail.smtp.host", "smtp.gmail.com");
       properties.put("mail.smtp.socketFactory.port", "465");
       properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
       properties.put("mail.smtp.auth", "true");
       properties.put("mail.smtp.port", "465");
       properties.put("mail.smtp.starttls.enable", "true");
       
       //creating session
       Session session = Session.getDefaultInstance(properties, new Authenticator() {
           
           protected PasswordAuthentication getPasswordAuthentication(){
               return new PasswordAuthentication(senderAddress, senderPassword);
           }
       });
       
       // compose message
       MimeMessage mimeMessage = new MimeMessage(session);
       try {
           mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverAddress));
           mimeMessage.setSubject(MailSub);
           mimeMessage.setText(mssg);
           
           // send message
           Transport.send(mimeMessage);
           System.out.println("Message sent successfully");
           
       } catch (AddressException ex) {
           Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
       } catch (MessagingException ex) {
           Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}
