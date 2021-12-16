package com.thuexcursion.crud.service;

import javax.mail.MessagingException;
import com.thuexcursion.crud.model.Mail;
import java.util.List;
public interface SendMailService {
    void sendMail(Mail mail);

    void sendMailToList(Mail mail);

    void sendMailWithAttachments(Mail mail) throws MessagingException;
}