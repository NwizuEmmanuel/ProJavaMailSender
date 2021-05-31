/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamailsender;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author Onyekachukwu
 */
public class JavaMailSender {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JavaMailUtil.SendEmail("nwizuemmanuel200@gmail.com", "enox1234", "nwizuemmanuel200@gmail.com", "Java mail", "Hey do you love program with java");
    }
    
}
