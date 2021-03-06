package com.aidijing.service;

import com.aidijing.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * The type Mail service.
 *
 * @author : 披荆斩棘
 * @date : 2017/3/26
 */
@Service
public class MailService {
    
    @Lazy
    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * Send.
     *
     * @param mailMessage the mail message
     */
    public void send ( SimpleMailMessage mailMessage ) {
        jmsTemplate.send( session -> session.createTextMessage( JsonUtils.GSON.toJson( mailMessage ) ) );
    }

}
