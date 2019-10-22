package com.study.piple.piple.subscribe;

import com.study.piple.piple.subscribe.abstractor.AbstractMessageSubscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DealMessageSubscribe extends AbstractMessageSubscribe {

    private static final Logger LOG = LoggerFactory.getLogger(DealMessageSubscribe.class);

    @Override
    public void receiveMessage(Object message) {
        LOG.info("接收成交消息: [{}]",message);
    }
}
