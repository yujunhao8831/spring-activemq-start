package com.aidijing.service;

import com.aidijing.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

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
        jmsTemplate.send( new MessageCreator() {
            @Override
            public Message createMessage ( Session session ) throws JMSException {
                return session.createTextMessage( JsonUtils.toJson( mailMessage ) );
            }
        } );
    }

}
