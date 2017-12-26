package com.hand.ysl.demo.kafka;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;
import com.hand.ysl.util.MyDbUtils;

/**
 * 处理来自KafkaSpout的tuple，并保存到数据库中
 *
 * @author shenfl
 * 本示例展示了从kafka的test这个topic接收消息并经过该自定义拓补对数据进行清洗 如果满足正则表达式
 * 则将匹配的数据按格式写入mysql数据库
 *
 * 先启动zookeeper 再启动kafka 再启动kafka的consumer topic是test
 * 接着启动flume flume的conf配置使用的resource的type是spooldir指定了要读取的日志文件的目录
 * sink输出是kafka，这样flume会从该指定目录读取日志内容然后输出到kafka
 *
 * 接着启动flume：将此项目打成带依赖的jar拷贝到storm的lib包下 运行：
 * storm jar GoTravelling.jar com.hand.ysl.demo.kafka.KafkaLogProcess
 * 然后当日志文件进入读取日志的目录  flume会读取日志内容到kafka，kafka将数据消费到storm
 * storm按正则匹配数据 把符合要求的数据按格式插入mysql
 *
 *
 */
public class LogFilterBolt extends BaseRichBolt {

    private OutputCollector collector;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    Pattern p = Pattern.compile("url\\[(.*)]\\,totalTime\\[([0-9]+)\\],when\\[([0-9]+)\\]");

    /**
     * 每个LogFilterBolt实例仅初始化一次
     */
    @Override
    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
        this.collector = collector;
    }

    @Override
    public void execute(Tuple input) {
        System.out.println("-------------receive messages----------------");
        try {
            // 接收KafkaSpout的数据
            byte[] bytes = input.getBinaryByField("bytes");
            String value = new String(bytes).replaceAll("[\n\r]", "");
            // 解析数据并入库
            Matcher m = p.matcher(value);
            if (m.find()) {
                String url = m.group(1);
                String usetime = m.group(2);
                String currentTime = m.group(3);
                System.out.println(url + "->" + usetime + "->" + currentTime);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                MyDbUtils.update(MyDbUtils.INSERT_LOG, url, usetime,
                        sdf.format(new Date(Long.parseLong(currentTime))));
            }
            this.collector.ack(input);
        } catch (Exception e) {
            this.collector.fail(input);
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
    }
}