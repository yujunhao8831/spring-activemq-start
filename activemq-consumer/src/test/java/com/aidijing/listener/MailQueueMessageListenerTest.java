package com.aidijing.listener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 披荆斩棘 on 2017/3/26.
 */
@ContextConfiguration( "classpath:applicationContext.xml" )
@RunWith( SpringJUnit4ClassRunner.class )
public class MailQueueMessageListenerTest {
    

    @Test
    public void start () throws Exception {
        Thread.sleep( Integer.MAX_VALUE );
    }
}