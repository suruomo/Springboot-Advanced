package com.suruomo.elasticsearch.service;

import com.suruomo.elasticsearch.entity.SmsLogs;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author suruomo
 * @date 2020/7/15 9:18
 * @description:
 */
@Service
@Slf4j
public class ESService {

    String index = "sms-logs-index";
    String type = "sms-logs-type";
    //注入bean
    @Qualifier("myClient")
    @Resource
    RestHighLevelClient client;

    public List<SmsLogs> search(String field) throws IOException, ParseException {
        List<SmsLogs> logs = new ArrayList<>();
        SearchRequest request = new SearchRequest(index);
        request.types(type);
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //按照field搜索内容
        builder.query(QueryBuilders.matchQuery("smsContent", field));
        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        for (SearchHit hit : response.getHits().getHits()) {
            //map对象
            Map<String, Object> result = hit.getSourceAsMap();
            //日期：String转Date
            DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
            Date date=fmt.parse(result.get("sendDate").toString());
            result.put("sendDate",date);
            date=fmt.parse(result.get("createDate").toString());
            result.put("createDate",date);
            //获取对象id
            String id=hit.getId();
            result.put("id",id);
            //bean
            SmsLogs smsLogs=new SmsLogs();
            //转换
            BeanMap beanMap= BeanMap.create(smsLogs);
            beanMap.putAll(result);
            logs.add(smsLogs);
            System.out.println(smsLogs.toString());
        }
        return logs;
    }
}

