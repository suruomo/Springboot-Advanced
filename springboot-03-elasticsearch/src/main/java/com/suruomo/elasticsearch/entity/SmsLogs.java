package com.suruomo.elasticsearch.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author suruomo
 * @date 2020/7/15 14:07
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmsLogs {
//    @JsonIgnore
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date sendDate;
    private String mobile;
    private String corpName;
    private String smsContent;
    private Integer operatorId;
    private Integer state;
    private Integer replyTotal;
    private Integer fee;
    private String province;
    private String ipAddr;
}
