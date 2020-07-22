package com.suruomo.elasticsearch.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author suruomo
 * @date 2020/7/15 9:15
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @JsonIgnore
    private int id;

    private String name;

    private int age;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

}
