package com.example.mail;

import com.example.mail.api.SenderMail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

@SpringBootTest
class MailApplicationTests {


    @Autowired
    private SenderMail senderMail;
    @Test
    void contextLoads() throws MessagingException {
        senderMail.sendThymeleafMail();
    }

}
