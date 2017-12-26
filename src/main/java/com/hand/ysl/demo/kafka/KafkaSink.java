package com.hand.ysl.demo.kafka;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import org.apache.flume.Channel;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.Transaction;
import org.apache.flume.conf.Configurable;
import org.apache.flume.sink.AbstractSink;

/**
 * 自定义KafkaSink，读取Flume的channel的数据，存储到Kafaka中
 *
 * @author shenfl
 *
 */
public class KafkaSink extends AbstractSink implements Configurable {

    private String myProp ;
    Producer<String, String> producer;
    /**
     * 在组件初始化的时候执行一次
     */
    public void configure(Context context){
        // init producer
        Properties props = new Properties();
        props.put("metadata.broker.list", "127.0.0.1:9092");// 此处配置的是kafka的端口
        props.put("serializer.class", "kafka.serializer.StringEncoder");// 配置value的序列化类
        ProducerConfig config = new ProducerConfig(props);
        this.producer = new Producer<String, String>(config);
        // Store myProp for later retrieval by process() method
        String myProp = context.getString("myProp", "test");//指定要消费的专题，默认为mytopic
        this.setMyProp(myProp) ;
    }

    public Status process() throws EventDeliveryException {
        Status status = null;
        // Start transaction
        Channel ch = getChannel();
        Transaction txn = ch.getTransaction();
        txn.begin();
        try {
            // Channel operations you want to do
            Event event = ch.take();
            String eventBody = new String(event.getBody());
            KeyedMessage<String, String> message = new KeyedMessage<String, String>(this.getMyProp(),eventBody);
            // Send the Event to the external repository.这里的external为kafka
            producer.send(message);
            txn.commit();
            status = Status.READY;
        } catch (Throwable t) {
            txn.rollback();
            // Log exception, handle individual exceptions as needed
            status = Status.BACKOFF;
            // re-throw all Errors
            if (t instanceof Error) {
                throw (Error) t;
            }
        } finally {
            txn.close();
        }
        return status;
    }
    public String getMyProp() {
        return myProp;
    }
    public void setMyProp(String myProp) {
        this.myProp = myProp;
    }
}