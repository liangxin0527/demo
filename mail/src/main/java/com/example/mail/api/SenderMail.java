package com.example.mail.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * @author liang
 * @date 2021/4/20
 */
@RestController("/mail")
public class SenderMail {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    TemplateEngine templateEngine;

    public void sendSimpleMail() {
        // 构建一个邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件主题
        message.setSubject("这是一封测试邮件");
        // 设置邮件发送者，这个跟application.yml中设置的要一致
        message.setFrom("7*****9@qq.com");
        // 设置邮件接收者，可以有多个接收者，中间用逗号隔开，以下类似
        // message.setTo("10*****16@qq.com","12****32*qq.com");
        message.setTo("10*****16@qq.com");
        // 设置邮件抄送人，可以有多个抄送人
        message.setCc("12****32*qq.com");
        // 设置隐秘抄送人，可以有多个
        message.setBcc("7******9@qq.com");
        // 设置邮件发送日期
        message.setSentDate(new Date());
        // 设置邮件的正文
        message.setText("这是测试邮件的正文");
        // 发送邮件
        javaMailSender.send(message);
    }

    @PostMapping("/send")
    public void sendThymeleafMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("入职通知");
        helper.setFrom("344805353@qq.com");
        helper.setTo("dongxinyou@luvsec.com");
        //设置抄送
      //  helper.setCc("37xxxxx37@qq.com");
        //设置隐秘抄送人
       // helper.setBcc("14xxxxx098@qq.com");
        helper.setSentDate(new Date());
        // 这里引入的是Template的Context
        Context context = new Context();
        // 设置模板中的变量
        context.setVariable("username", "贾永昌");
        context.setVariable("num", "000001");
        context.setVariable("salary", "40k");
        // 第一个参数为模板的名称
        String process = templateEngine.process("mail.html", context);
        // 第二个参数true表示这是一个html文本
        helper.setText(process, true);
        javaMailSender.send(mimeMessage);
    }
}
