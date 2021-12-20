package com.hypers.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hypers.crius.enhance.BaseEntity;
import com.hypers.entity.vo.IdRawSourcePathVo;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Lynne
 * @date 2021/12/7
 */
@Data
public class WareHousing implements BaseEntity {

    private Long id;

    private IdRawSourcePathVo rawSource;

    @JsonIgnore
    private String file;

    @JsonIgnore
    private List<String> header;

    private String tableName;

    private String dataBase;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
