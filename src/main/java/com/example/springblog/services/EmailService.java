package com.example.springblog.services;

import com.example.springblog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("emailService")

public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Value("${spring.mail.from}")
    private String from;

    public void prepareAndSend(Post post, String subject) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(post.getUser().getEmail());
        msg.setSubject(subject);
        String body = "Thank you for posting to this SpringBlog! The title of your post submitted was [" + post.getTitle() + "]. If this was not you, please contact customer support.";
        msg.setText(body);

        try {
            this.emailSender.send(msg);
        } catch(MailException mex) {
            System.out.println(mex.getMessage());
        }
    }
}
