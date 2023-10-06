package com.inProject.in.domain.CommonLogic.Mail.service;


import com.inProject.in.domain.CommonLogic.Mail.Dto.SendMailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private JavaMailSender javaMailSender;
    private static final String FROM_ADMIN = "tlsdbstjd124@gmail.com";

    @Autowired
    public MailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }
    public void sendMail(SendMailDto sendMailDto){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(sendMailDto.getAddress());
        simpleMailMessage.setSubject(sendMailDto.getSubject());
        simpleMailMessage.setText(sendMailDto.getText());
        simpleMailMessage.setFrom(FROM_ADMIN);

        javaMailSender.send(simpleMailMessage);
    }

}
