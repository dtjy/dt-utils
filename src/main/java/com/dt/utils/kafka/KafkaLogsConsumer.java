package com.dt.utils.kafka;

import com.dt.utils.util.RedisUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author jiangyao
 * @Date 2020/4/14 9:08
 **/
@Component
public class KafkaLogsConsumer {

    private static Logger LOGGER = LoggerFactory.getLogger(KafkaLogsConsumer.class);

    public static final String CONSUMER_ENABLE_AUTO_COMMIT = "false";       //是否自动提交（消费者）

    private static final String TOPIC_PREFIX = "LOG_TOPIC";
    private static final String TEST_TOPIC = "TEST_TOPIC";
    private static final String TOPIC_DATE_PATTERN = "yyyy-MM-dd";

    @Autowired
    RedisUtil redisUtil;

    @KafkaListener(topics = TOPIC_PREFIX)
    public void listenMsg (ConsumerRecord<?,String> record) {
        String value = record.value();
        LOGGER.info(">>>>>>>>>>>>>>>>>>"+value);
        String format = DateFormatUtils.format(new Date(), TOPIC_DATE_PATTERN);
        redisUtil.lSet(KafkaLogsConsumer.TOPIC_PREFIX+"_"+format,value);
    }

    @KafkaListener(topics = TEST_TOPIC)
    public void testMsg (ConsumerRecord<?,String> record) {
        LOGGER.info(">>>>>>>>>>>>>>>>>>{}-{}-{}",record.value(),record.partition(),record.offset());
    }

//    @KafkaListener(topics = TEST_TOPIC)
//    public void testMsgOfferset (ConsumerRecord<?,String> record) {
//        String value = record.value();
//        LOGGER.info(">>>>>>>>>>>>>>>>>>"+value);
//    }

//    @KafkaListener(topics = TEST_TOPIC)
//    public void testMsgOfferset (ConsumerRecord<?,String> record) {
//        String value = record.value();
//        LOGGER.info(">>>>>>>>>>>>>>>>>>"+value);
//    }

}
