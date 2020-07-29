package com.suruomo.springboot10mybatis.service.common;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author suruomo
 * @date 2020/7/29 13:26
 * @description:
 */
@Service
public interface IService<T> {

    List<T> selectAll();

    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);
}