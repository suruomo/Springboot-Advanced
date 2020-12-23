package com.suruomo.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suruomo.mybatisplus.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: suruomo
 * @Date: 2020/8/25 14:40
 * @Description: 继承 BaseMapper<T> 接口即可获得通用的增删改查功能
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
