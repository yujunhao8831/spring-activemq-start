package com.aidijing.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 披荆斩棘 on 2017/3/26.
 */
@ContextConfiguration( "classpath:applicationContext.xml" )
@RunWith( SpringJUnit4ClassRunner.class )
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void send () throws Exception {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo( "yujunhao_8831@yahoo.com" );
        message.setSubject( "异步发送邮件" );
        message.setFrom( "yujunhao_8831@163.com" );
        message.setText( "hello world, by pi jing zhang ji" );
        mailService.send( message );
        System.err.println( "邮寄发送完毕." );
    }

}