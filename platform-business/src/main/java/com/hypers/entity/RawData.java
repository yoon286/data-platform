package com.hypers.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hypers.crius.enhance.BaseEntity;
import com.hypers.entity.enums.Operation;
import com.hypers.entity.vo.IdMetaDataVo;
import lombok.Data;

import java.util.Date;

/**
 * @author Lynne
 * @date 2021/12/8
 */

@Data
public class RawData implements BaseEntity {

    private Long id;

    private IdMetaDataVo metaData;

    private Operation operation;

    private String sql;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date processTime;

}
