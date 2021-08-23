package com.example.variousdemo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @className: MailServiceTest
 * @description:
 * @created: 2021/08/23 11:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;
    @Test
    public void testSimpleMail() {
        mailService.sendSimpleMail("295836675@qq.com","hcTest-����","Hello,World");
    }

    @Test
    public void testSendHtmlMail(){
        String content = "<html><body><h3>hello world</h3></body></html>";
        mailService.sendHtmlMail("295836675@qq.com","hcTest-HTML",content);
    }

    @Test
    public void testAttachmentsMail(){
        String filePath = "F:\\Readme(zh_CN).pdf";
        mailService.sendAttachmentsMail("295836675@qq.com","hcTest-Attachment","�и���",filePath);
    }

    @Test
    public void sendTemplateMail(){
        //�����ʼ�����
        Context context = new Context();
        context.setVariable("id","006");
        String emailContent = templateEngine.process("emailTemplate",context);
        mailService.sendHtmlMail("295836675@qq.com","hcTest-finally",emailContent);
    }
}
