package com.hypers.dao;

/**
 * @author Lynne
 * @date 2021/12/8
 */


import com.hypers.crius.enhance.BaseDao;
import com.hypers.entity.RawData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RawDataDao extends BaseDao<RawData> {
    /**
     *通过元数据Id查找操作记录
     * @param id 元数据Id
     * @return 操作记录
     */
    List<RawData> findById(@Param("id") Long id);

}
