package com.thuexcursion.crud.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import com.thuexcursion.crud.model.Mail;

import com.thuexcursion.crud.model.User;
import com.thuexcursion.crud.repository.UserRepository;

import java.util.Iterator;
import java.util.List;

@Service
public class SendMailServiceImpl implements SendMailService {
    private final JavaMailSender javaMailSender;

    @Autowired
	private UserRepository userRepository;

    public SendMailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
	 * @param Mail 
     * @apiNote sendMail() is a function which sends a mail notification only for one receiver
	 */

    @Override
    public void sendMail(Mail mail) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail.getRecipient(), mail.getRecipient());
        msg.setSubject(mail.getSubject());
        msg.setText(mail.getMessage());
        javaMailSender.send(msg);
    }

     /**
	 * @param Mail 
     * @apiNote sendMailToList() is a function which sends a mail notification to a list of emails in specified in the User table
	 */
    @Override
    public void sendMailToList(Mail mail) {
        Iterator it = userRepository.fetchEmailingList().iterator();
        while(it.hasNext()){
            String recepient = it.next().toString();
            
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(recepient, recepient);
            msg.setSubject(mail.getSubject());
            msg.setText(mail.getMessage());
            javaMailSender.send(msg);
        }
    }

    @Override
    public void sendMailWithAttachments(Mail mail) throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("to_@email");
        helper.setSubject("Testing from Spring Boot");
        helper.setText("Find the attached image", true);
        helper.addAttachment("hero.jpg", new ClassPathResource("hero.jpg"));
        javaMailSender.send(msg);
    }


    /*public List<String> fetchEmailingList(){
		return userRepository.fetchEmailingList();
	}*/
}