package com.thuexcursion.crud.controller;


import com.thuexcursion.crud.model.Mail;
import com.thuexcursion.crud.service.SendMailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.mail.MessagingException;

/**
 * This is a controller class for notification by mail functionality. This class, in the future, might also include all
 * forms of notification aside from email
 * 
 *  For more information about EmailController, check swagger documentatio for endpoints
 */
@RestController
@RequestMapping("/api/v1/mail/")
public class EmailController {
    SendMailService service;

    public EmailController(SendMailService service) {
        this.service = service;
    }

    /**
     * This method is used to send a notification to a single email
     * @param mail an object which contains: sender, receiver and message
     * @return returns http status and a message if successfully sent
     */
    @PostMapping("/send")
    public ResponseEntity<String> sendMail(@RequestBody Mail mail) {
        service.sendMail(mail);
        return new ResponseEntity<>("Email Sent successfully", HttpStatus.OK);
    }

     /**
     * This method is used to send a notifications to list of emails
     * @param mail an object which contains: sender, receiver and message which sends to mailing list in user table
     * @return returns http status and a message if successfully sent
     */

	@PostMapping("/sendtolist")
    public ResponseEntity<String> sendMailToList(@RequestBody Mail mail) {
        service.sendMailToList(mail);
        return new ResponseEntity<>("Email Sent successfully", HttpStatus.OK);
    }

     /**
     * Not completely implemented yet. (For the future)
     * @param mail an object which contains: sender, receiver and message.
     * @return returns http status and a message if successfully sent
     */

    @PostMapping("/attachment")
    public ResponseEntity<String> sendAttachmentEmail(@RequestBody Mail mail) throws MessagingException {
        service.sendMailWithAttachments(mail);
        return new ResponseEntity<>("Attachment mail sent successfully", HttpStatus.OK);
    }
}