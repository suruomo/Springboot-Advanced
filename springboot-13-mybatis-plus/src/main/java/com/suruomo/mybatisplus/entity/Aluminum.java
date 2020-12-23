package com.suruomo.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class Aluminum implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @TableField("CSMMBR_NAME")
    private String csmmbrName;

    @TableField("FAMILY")
    private String family;

    @TableField("SPECIFICATION")
    private String specification;

    @TableField("FORM")
    private String form;

    @TableField("TEMPER")
    private String temper;

    @TableField("TEMPERATURE")
    private String temperature;

    @TableField("DENSITY")
    private String density;

    @TableField("BOOKS")
    private String books;

    @TableField("AIRCRAFTID")
    private String aircraftid;

    @TableField("TH_MIN")
    private String thMin;

    @TableField("TH_MAX")
    private String thMax;

    @TableField("BASIS")
    private String basis;

    @TableField("DIRECTION")
    private String direction;

    @TableField("E")
    private String e;

    @TableField("E_C")
    private String eC;

    @TableField("F_CY")
    private String fCy;

    @TableField("F_SU")
    private String fSu;

    @TableField("G")
    private String g;

    @TableField("NU")
    private String nu;


}
