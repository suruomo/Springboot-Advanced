package com.suruomo.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author suruomo
 * @since 2020-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysLog implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     *  访问模块
     */
    private String module;

    /**
     *  访问方法
     */
    private String method;

    /**
     *  访问参数
     */
    private String parameter;

    /**
     *  响应时间ms
     */
    private String responseTime;

    /**
     *  时间
     */
    private String date;

    /**
     *  相应状况（成功or失败）
     */
    private String commit;

    /**
     * ip地址
     */
    private String ip;


}
