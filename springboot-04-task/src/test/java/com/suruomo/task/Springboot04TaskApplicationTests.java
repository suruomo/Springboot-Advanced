package com.suruomo.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot04TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    /**
     * 发送简单邮件
     */
    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("通知-今晚开会");
        message.setText("今晚7:30开会");

        message.setTo("805987815@qq.com");
        message.setFrom("suruomo1@163.com");
        mailSender.send(message);
    }

    /**
     * 发送复杂邮件
     * @throws Exception
     */
    @Test
    public void test02() throws  Exception{
        //1、创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        helper.setSubject("通知-今晚开会");
        helper.setText("<b style='color:red'>今天 7:30 开会</b>",true);

        helper.setTo("805987815@qq.com");
        helper.setFrom("suruomo1@163.com");

        //上传文件
        helper.addAttachment("1.jpg",new File("F:\\图片\\电脑壁纸\\1a5b2305f2ed6c385119ea310b7bf149.jpg"));
        mailSender.send(mimeMessage);

    }
}
