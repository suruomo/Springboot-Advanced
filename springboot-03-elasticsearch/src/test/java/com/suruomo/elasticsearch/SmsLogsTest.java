package com.suruomo.elasticsearch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suruomo.elasticsearch.entity.SmsLogs;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

/**
 * @author suruomo
 * @date 2020/7/15 14:24
 * @description: ES小练习，sms-logs
 */
@SpringBootTest
public class SmsLogsTest {
    String index = "sms-logs-index";
    String type = "sms-logs-type";
    //注入bean
    @Qualifier("myClient")
    @Resource
    RestHighLevelClient client;

    @Resource
    private ObjectMapper mapper;

    /**
     * 添加数据
     */
    @Test
    void addDataTest() throws IOException {
        //创建对象
        SmsLogs s1=new SmsLogs("6",new Date(),new Date(),"12345678901","浙江商务贸易有限责任公司", "市气象台发布高温橙色预警",1,0,231,12,"浙江","192.123.12.1");
        SmsLogs s2=new SmsLogs("7",new Date(),new Date(),"123123123","广西石油运输动力公司", "欢迎关注易通公众号，有限领取入会资格哦",2,0,1231,23,"广西","196.123.12.1");
        SmsLogs s3=new SmsLogs("8",new Date(),new Date(),"43254353","北京文娱有限责任公司", "恭喜您被选中参加我司两年一度的抽奖大赛，获奖者可以获得新能源汽车一台",3,0,221,12,"北京","191.123.12.1");
        SmsLogs s4=new SmsLogs("9",new Date(),new Date(),"4534623","苏州纺织制造公司", "您好，您的中通快递已经到达楼下的菜鸟驿站哦，请及时领取",2,0,2331,0,"江苏","193.123.12.1");
        SmsLogs s5=new SmsLogs("10",new Date(),new Date(),"875635354","山西广播电视台有限责任公司", "中国工商银行提醒您，请及时申领电子社保卡，可以登录中国工商银行手机客户端领取",1,0,21312,56,"山西","194.123.12.1");
        String json1=mapper.writeValueAsString(s1);
        String json2=mapper.writeValueAsString(s2);
        String json3=mapper.writeValueAsString(s3);
        String json4=mapper.writeValueAsString(s4);
        String json5=mapper.writeValueAsString(s5);
        //封装request
        BulkRequest request=new BulkRequest();
        request.add(new IndexRequest(index,type,s1.getId().toString()).source(json1, XContentType.JSON));
        request.add(new IndexRequest(index,type,s2.getId().toString()).source(json2, XContentType.JSON));
        request.add(new IndexRequest(index,type,s3.getId().toString()).source(json3, XContentType.JSON));
        request.add(new IndexRequest(index,type,s4.getId().toString()).source(json4, XContentType.JSON));
        request.add(new IndexRequest(index,type,s5.getId().toString()).source(json5, XContentType.JSON));
        //执行
        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }
}
