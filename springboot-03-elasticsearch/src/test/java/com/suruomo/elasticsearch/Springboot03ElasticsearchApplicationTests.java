package com.suruomo.elasticsearch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suruomo.elasticsearch.entity.Person;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author suruomo
 * @description:  ES基本操作
 */
@SpringBootTest
class Springboot03ElasticsearchApplicationTests {

    String index = "person";
    String type = "man";
    //注入bean
    @Qualifier("myClient")
    @Resource
    RestHighLevelClient client;

    @Resource
    private ObjectMapper mapper;

    /**
     * 创建索引
     */
    @Test
    void createIndex() throws IOException {
        //索引设置
        Settings.Builder settings = Settings.builder().put("number_of_shards", 3).put("number_of_replicas", 1);
        //索引mappings
        XContentBuilder mappings = JsonXContent.contentBuilder()
                .startObject()
                .startObject("properties")
                .startObject("name")
                .field("type", "text")
                .endObject()
                .startObject("age")
                .field("type", "integer")
                .endObject()
                .startObject("birthday")
                .field("type", "date")
                .field("format", "yyyy-MM-dd")
                .endObject()
                .endObject()
                .endObject();
        //封装settings和mappings
        CreateIndexRequest request = new CreateIndexRequest(index)
                .settings(settings)
                .mapping(type, mappings);
        //client对象连接ES并创建索引
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println("返回" + response);
    }

    /**
     * 是否存在索引
     */
    @Test
    void isExitsIndex() throws IOException {
        //准备request对象
        GetIndexRequest request = new GetIndexRequest();
        request.indices(index);
        //client操作ES，返回结果
        boolean exits = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println("是否存在索引：" + exits);
    }

    /**
     * 删除索引
     */
    @Test
    void deleteIndex() throws IOException {
        //准备request对象
        DeleteIndexRequest request = new DeleteIndexRequest();
        request.indices(index);
        //client操作ES,返回结果
        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println("删除索引返回：" + response.isAcknowledged());
    }

    /**
     * 添加文档
     */
    @Test
    void createDoc() throws IOException {
        //1.准备json数据
        Person person = new Person(1, "小明", 23, new Date());
        String json = mapper.writeValueAsString(person);
        //2.准备request对象,手动只当id
        IndexRequest request = new IndexRequest(index, type, String.valueOf(person.getId()));
        request.source(json, XContentType.JSON);
        //3.client操作ES
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    /**
     * 修改文档
     */
    @Test
    void updateDoc() throws IOException {
        //创建map，指定修改内容
        Map<String, Object> doc = new HashMap<>();
        doc.put("name", "张三");
        String docId = "1";
        //创建request，封装数据
        UpdateRequest request = new UpdateRequest(index, type, docId);
        request.doc(doc);
        //client操作ES
        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    /**
     * 删除文档
     */
    @Test
    void deleteDoc() throws IOException {
        //封装request对象
        DeleteRequest request = new DeleteRequest(index, type, "1");
        //client执行ES
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    /**
     * 批量添加文档
     */
    @Test
    void bulkCreateDoc() throws IOException {
        //准备多个json数据
        Person person1 = new Person(1, "张一", 21, new Date());
        Person person2 = new Person(2, "张二", 22, new Date());
        Person person3 = new Person(3, "张三", 23, new Date());
        String json1 = mapper.writeValueAsString(person1);
        String json2 = mapper.writeValueAsString(person2);
        String json3 = mapper.writeValueAsString(person3);
        //创建request对象
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest(index, type, String.valueOf(person1.getId())).source(json1, XContentType.JSON));
        request.add(new IndexRequest(index, type, String.valueOf(person2.getId())).source(json2, XContentType.JSON));
        request.add(new IndexRequest(index, type, String.valueOf(person3.getId())).source(json3, XContentType.JSON));
        // client执行ES
        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    /**
     * 批量删除文档
     */
    @Test
    void bulkDeleteDoc() throws IOException {
        //封装request对象
        BulkRequest request = new BulkRequest();
        request.add(new DeleteRequest(index, type, "1"));
        request.add(new DeleteRequest(index, type, "2"));
        request.add(new DeleteRequest(index, type, "3"));
        //client执行
        BulkResponse responses = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(responses);
    }
}
