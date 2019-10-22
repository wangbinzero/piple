package com.study.piple.piple.subscribe;

import com.study.piple.piple.subscribe.abstractor.AbstractMessageSubscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderMessageSubscribe extends AbstractMessageSubscribe {

    private static final Logger LOG = LoggerFactory.getLogger(OrderMessageSubscribe.class);

    @Override
    public void receiveMessage(Object message) {
        LOG.info("接收订单消息:[{}]", message);
    }
}
