package com.suruomo.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suruomo.mybatisplus.mapper.SysUserMapper;
import com.suruomo.mybatisplus.model.SysUser;
import org.springframework.stereotype.Service;

/**
 * @Author: suruomo
 * @Date: 2020/8/25 19:36
 * @Description:
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
