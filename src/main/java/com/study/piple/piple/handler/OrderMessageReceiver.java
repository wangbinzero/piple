package com.study.piple.piple.handler;

import com.study.piple.piple.handler.abstractor.AbstractMessageReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderMessageReceiver extends AbstractMessageReceiver {

    private static final Logger LOG = LoggerFactory.getLogger(OrderMessageReceiver.class);

    @Override
    public void receiveMessage(Object message) {
        LOG.info("接收订单消息:[{}]", message);
    }
}
