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

@RestController
@RequestMapping("/api/v1/mail/")
public class EmailController {
    SendMailService service;

    public EmailController(SendMailService service) {
        this.service = service;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMail(@RequestBody Mail mail) {
        service.sendMail(mail);
        return new ResponseEntity<>("Email Sent successfully", HttpStatus.OK);
    }

	@PostMapping("/sendtolist")
    public ResponseEntity<String> sendMailToList(@RequestBody Mail mail) {
        System.out.println("****** send to list ******");
        service.sendMailToList(mail);
        return new ResponseEntity<>("Email Sent successfully", HttpStatus.OK);
    }

    @PostMapping("/attachment")
    public ResponseEntity<String> sendAttachmentEmail(@RequestBody Mail mail) throws MessagingException {
        service.sendMailWithAttachments(mail);
        return new ResponseEntity<>("Attachment mail sent successfully", HttpStatus.OK);
    }
}