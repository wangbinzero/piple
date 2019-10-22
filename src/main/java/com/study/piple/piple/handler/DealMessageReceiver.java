package com.study.piple.piple.handler;

import com.study.piple.piple.handler.abstractor.AbstractMessageReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DealMessageReceiver extends AbstractMessageReceiver {

    private static final Logger LOG = LoggerFactory.getLogger(DealMessageReceiver.class);

    @Override
    public void receiveMessage(Object message) {
        LOG.info("接收成交消息: [{}]",message);
    }
}
