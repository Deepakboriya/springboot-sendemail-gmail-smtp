package com.learning.service.impl;

import com.learning.model.EmailDetails;
import com.learning.service.EmailService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Objects;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public void sendSimpleEmail(EmailDetails emailDetails) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setTo(emailDetails.getRecipient());
        simpleMailMessage.setText(emailDetails.getMsgBody());
        simpleMailMessage.setSubject(emailDetails.getSubject());



        javaMailSender.send(simpleMailMessage);
    }

    @SneakyThrows
    @Override
    public void sendEmailWithAttachment(EmailDetails emailDetails) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(sender);
        mimeMessageHelper.setTo(emailDetails.getRecipient());
        mimeMessageHelper.setText(emailDetails.getMsgBody());
        mimeMessageHelper.setSubject(emailDetails.getSubject());

        // Adding the attachment
        FileSystemResource file = new FileSystemResource(new File(emailDetails.getAttachment()));
        mimeMessageHelper.addAttachment(Objects.requireNonNull(file.getFilename()), file);

        // Sending the mail
        javaMailSender.send(mimeMessage);
    }
}
