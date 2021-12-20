package com.hypers.dao;

import com.hypers.crius.enhance.BaseDao;
import com.hypers.entity.ProcessedData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Lynne
 * @date 2021/12/9
 */

@Mapper
public interface ProcessedDataDao extends BaseDao<ProcessedData> {

    void importToRepository(@Param("e") ProcessedData processedData);

}
