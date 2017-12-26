package com.hand.ysl.demo.kafka;
import java.util.UUID;

import storm.kafka.KafkaSpout;
import storm.kafka.SpoutConfig;
import storm.kafka.ZkHosts;
import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;

/**
 * Storm读取Kafka消息中间件数据
 *
 * @author shenfl
 *
 */
public class KafkaLogProcess {


    private static final String BOLT_ID = LogFilterBolt.class.getName();
    private static final String SPOUT_ID = KafkaSpout.class.getName();

    public static void main(String[] args) {

        TopologyBuilder builder = new TopologyBuilder();
        //表示kafka使用的zookeeper的地址
        String brokerZkStr = "127.0.0.1:2181";
        ZkHosts zkHosts = new ZkHosts(brokerZkStr);
        //表示的是kafak中存储数据的主题名称
        String topic = "test";
        //指定zookeeper中的一个根目录，里面存储kafkaspout读取数据的位置等信息
        String zkRoot = "/kafkaspout";
        String id = UUID.randomUUID().toString();
        SpoutConfig spoutconf  = new SpoutConfig(zkHosts, topic, zkRoot, id);
        builder.setSpout(SPOUT_ID , new KafkaSpout(spoutconf));
        builder.setBolt(BOLT_ID,new  LogFilterBolt()).shuffleGrouping(SPOUT_ID);

        LocalCluster localCluster = new LocalCluster();
        localCluster.submitTopology(KafkaLogProcess.class.getSimpleName(), new Config(), builder.createTopology() );
    }
}