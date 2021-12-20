package com.hypers.service.impl;

import com.hypers.crius.enhance.AbstractBaseService;
import com.hypers.dao.ProcessedDataDao;
import com.hypers.entity.ProcessedData;
import com.hypers.service.ProcessedDataService;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

/**
 * @author Lynne
 * @date 2021/12/9
 */
@Service
public class ProcessedDataServiceImpl extends AbstractBaseService<ProcessedData, ProcessedDataDao> implements ProcessedDataService {


    @Override
    public Object importToRepository(ProcessedData processedData, BindingResult result) {
        if(result.hasErrors()){
            return result;
        }
        getDao().importToRepository(processedData);
        getDao().save(processedData);
        return "success";
    }
}
