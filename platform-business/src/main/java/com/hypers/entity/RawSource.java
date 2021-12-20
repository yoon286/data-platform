package com.hypers.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hypers.crius.enhance.BaseEntity;
import com.hypers.entity.enums.Status;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author Lynne
 * @date 2021/12/5
 */

@Data
public class RawSource implements BaseEntity {

    private Long id;

    @Pattern(regexp = "https://([\\w-.])+[\\w-./#?%&=*;]*")
    private String url;

    private String fileName;

    private String filePath;

    private Status status;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}

