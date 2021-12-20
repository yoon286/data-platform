package com.hypers.service;

import com.hypers.crius.enhance.AbstractBaseService;
import com.hypers.crius.enhance.BaseService;
import com.hypers.dao.RawSourceDao;
import com.hypers.entity.RawSource;
import com.hypers.entity.WareHousing;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lynne
 * @date 2021/12/7
 */

public interface RawSourceService extends BaseService<RawSource> {
    /**
     * 入库
     * @param wareHousing 入库信息
     */
    void inbound(WareHousing wareHousing);

    List<WareHousing> findInboundRecords(WareHousing wareHousing);

    void saveInboundRecords(WareHousing wareHousing);
}
