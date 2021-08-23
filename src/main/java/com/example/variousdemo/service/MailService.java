package com.example.variousdemo.service;

public interface MailService {

    void sendSimpleMail(String to,String subject,String content);

    void sendHtmlMail(String to,String subject,String content);

    void sendAttachmentsMail(String to,String subject,String content,String filePath);

    void sendInlineResourceMail(String to,String subject,String content,String rscId);
}
