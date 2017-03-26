package com.aidijing.listener;

import com.aidijing.service.MailService;
import com.aidijing.utils.JsonUtils;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author : 披荆斩棘
 * @date : 2017/3/26
 * 队列消费监听
 */
@Component
public class MailQueueMessageListener implements SessionAwareMessageListener< TextMessage > {

    @Lazy
    @Autowired
    private JmsTemplate   jmsTemplate;
    @Lazy
    @Autowired
    private ActiveMQQueue activeMQQueue;
    @Lazy
    @Autowired
    private MailService   mailService;

    @Override
    public void onMessage ( TextMessage message, Session session ) throws JMSException {
        final SimpleMailMessage simpleMailMessage = JsonUtils.GSON.fromJson(
                message.getText(),
                SimpleMailMessage.class
        );

        if ( null == simpleMailMessage ) {
            System.err.println( "simpleMailMessage is null , end. " );
            return;
        }
        this.mailService.send( simpleMailMessage );
        System.err.println( "发送完毕" );

    }
}



















