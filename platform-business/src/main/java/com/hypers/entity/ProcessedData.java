package com.hypers.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hypers.crius.enhance.BaseEntity;
import com.hypers.entity.vo.IdRawSourcePathVo;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author Lynne
 * @date 2021/12/5
 */

@Data
public class ProcessedData implements BaseEntity {

    private Long id;

    private String tableName;

    private String dataBase;

    private String targetName;

    @Pattern(regexp = "",message = "路径不正确！")
    private String targetPath;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
