package com.aidijing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * @author : 披荆斩棘
 * @date : 2017/3/26
 */
@Service
public class MailService {

    @Lazy
    @Autowired
    private MailSender             mailSender;
    @Lazy
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


    public void send ( SimpleMailMessage mailMessage ) {
        this.threadPoolTaskExecutor.execute( () -> {
            this.mailSender.send( mailMessage );
        } );
    }

}
