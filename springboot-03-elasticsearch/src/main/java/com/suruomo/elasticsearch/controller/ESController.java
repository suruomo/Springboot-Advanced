package com.suruomo.elasticsearch.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suruomo.elasticsearch.entity.SmsLogs;
import com.suruomo.elasticsearch.service.ESService;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author suruomo
 * @date 2020/7/15 9:16
 * @description:
 */
@Controller
public class ESController {

    @Resource
    private ESService service;

    @Resource
    private ObjectMapper mapper;

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @PostMapping("/search")
    @ResponseBody
    public Map<String, Object> search(@RequestParam("field")String field) throws IOException, ParseException {
        System.out.println(field);
        List<SmsLogs> logs=service.search(field);
        Map<String, Object> map = new HashMap();
        //json内对象不为空
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String data = mapper.writeValueAsString(logs);
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", data);
        map.put("count", data.length());
        return map;
    }
}
