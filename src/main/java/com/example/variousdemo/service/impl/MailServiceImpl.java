//package com.example.variousdemo.service.impl;
//
//import com.example.variousdemo.service.MailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.stereotype.Component;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import java.io.File;
//
///**
// * @className: MailServiceImpl
// * @description:
// * @created: 2021/08/23 10:45
// */
//@Component
//public class MailServiceImpl implements MailService {
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Value("${mail.fromMail.addr}")
//    private String from;
//    /**
//     * 功能描述：
//     * 〈发送文本邮件〉
//     * @Date: 10:46 2021/8/23 0023
//     * @param to
//     * @param subject
//     * @param content
//     * @return: void
//     **/
//    @Override
//    public void sendSimpleMail(String to, String subject, String content) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(from);
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(content);
//        try {
//            mailSender.send(message);
//        } catch (Exception e){
//
//        }
//    }
//
//    /**
//     * 功能描述：
//     * 〈发送html邮件〉
//     * @Date: 11:14 2021/8/23 0023
//     * @param to
//     * @param subject
//     * @param content
//     * @return: void
//     **/
//    @Override
//    public void sendHtmlMail(String to, String subject, String content) {
//        MimeMessage message = mailSender.createMimeMessage();
//        try{
//            //true表示要创建一个multiple message
//            MimeMessageHelper helper = new MimeMessageHelper(message,true);
//            helper.setFrom(from);
//            helper.setTo(to);
//            helper.setSubject(subject);
//            helper.setText(content,true);
//            mailSender.send(message);
//        } catch (MessagingException e){
//
//        }
//    }
//
//    @Override
//    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
//        MimeMessage message = mailSender.createMimeMessage();
//        try{
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            helper.setFrom(from);
//            helper.setTo(to);
//            helper.setSubject(subject);
//            helper.setText(content,true);
//            FileSystemResource file = new FileSystemResource(new File(filePath));
//            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
//            helper.addAttachment(fileName,file);
//            mailSender.send(message);
//        }catch (MessagingException e){
//
//        }
//    }
//}
