package com.hypers.service;

import com.hypers.crius.enhance.BaseService;
import com.hypers.entity.RawData;

import java.util.List;

/**
 * @author Lynne
 * @date 2021/12/8
 */

public interface RawDataService extends BaseService<RawData> {

    Object processData(RawData rawData);

    List<RawData> findById(Long id);

}
