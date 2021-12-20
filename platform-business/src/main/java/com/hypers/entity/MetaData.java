package com.hypers.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hypers.crius.enhance.BaseEntity;
import com.hypers.entity.vo.IdRawSourcePathVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Lynne
 * @date 2021/12/5
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetaData implements BaseEntity {

    private Long id;

    private IdRawSourcePathVo rawSource;

    private String tableName;

    private String dataBase;

    private int column;

    private int row;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
