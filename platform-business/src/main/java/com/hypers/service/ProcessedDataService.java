package com.hypers.service;

import com.hypers.crius.enhance.BaseService;
import com.hypers.entity.ProcessedData;
import org.springframework.validation.BindingResult;

/**
 * @author Lynne
 * @date 2021/12/9
 */

public interface ProcessedDataService extends BaseService<ProcessedData> {

    Object importToRepository(ProcessedData processedData, BindingResult result);
}
