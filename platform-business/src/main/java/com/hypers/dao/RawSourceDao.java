package com.hypers.dao;

import com.hypers.crius.enhance.BaseDao;
import com.hypers.entity.RawSource;
import com.hypers.entity.WareHousing;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author Lynne
 * @date 2021/12/7
 */

@Mapper
public interface RawSourceDao extends BaseDao<RawSource> {

    /**
     * csv文件入库
     * @param wareHousing 入库信息
     */
    void inbound(@Param("e") WareHousing wareHousing);

    /**
     * check inbound records
     * @param wareHousing warehousingInfo
     * @return inbound records
     */
    List<WareHousing> findInboundRecords(@Param("e") WareHousing wareHousing);

    /**
     * save inbound records
     * @param wareHousing warehousingInfo
     */
    void saveInboundRecords(@Param("e") WareHousing wareHousing);
}
