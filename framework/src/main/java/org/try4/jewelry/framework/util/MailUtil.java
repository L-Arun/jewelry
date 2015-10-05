package org.try4.jewelry.framework.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailUtil {
	
	// Spring的邮件工具类，实现了MailSender和JavaMailSender接口
    private static JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    
    static{
        // 设置参数
        mailSender.setHost("smtp.qq.com");
        mailSender.setUsername("yu.haikun@carlinkstar.com");
        mailSender.setPassword("yhkrb2003");
    }
     
    public static void sendSimple(String to,String subject,String text) {
    	 // 构建简单邮件对象，见名知意
        SimpleMailMessage smm = new SimpleMailMessage();
        // 设定邮件参数
        smm.setFrom(mailSender.getUsername());
        smm.setTo(to);
        smm.setSubject(subject);
        smm.setText(text);
        // 发送邮件
        mailSender.send(smm);
    }
    
    public static void sendAttach(String to,String subject,String text,String attachPath,String attachName){
    	try{
    		//使用JavaMail的MimeMessage，支付更加复杂的邮件格式和内容
            MimeMessage msg = mailSender.createMimeMessage();
            //创建MimeMessageHelper对象，处理MimeMessage的辅助类
            MimeMessageHelper helper = new MimeMessageHelper(msg, true,"GBK");
            //使用辅助类MimeMessage设定参数
            helper.setFrom(mailSender.getUsername());
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);
            //加载文件资源，作为附件
            ClassPathResource file = new ClassPathResource(attachPath);
            //加入附件
            helper.addAttachment(attachName, file);
            //发送邮件
            mailSender.send(msg);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        
    }
    
    /**发送富文本邮件
     * @throws MessagingException
     */
    public static void sendRichContent(String to,String subject,String text) {
    	try{
    		MimeMessage msg = mailSender.createMimeMessage();
    	     
            MimeMessageHelper helper = new MimeMessageHelper(msg, true,"GBK");
         
            helper.setFrom(mailSender.getUsername());
            helper.setTo(to);
            helper.setSubject(subject);
            //第二个参数true，表示text的内容为html，然后注意<img/>标签，src='cid:file'，'cid'是contentId的缩写，'file'是一个标记，需要在后面的代码中调用MimeMessageHelper的addInline方法替代成文件
            helper.setText(text,true);
         
//            FileSystemResource file = new FileSystemResource(
//                    "C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg");
//            helper.addInline("file", file);
            mailSender.send(msg);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        
    }

}
