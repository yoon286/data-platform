package com.hypers.controller;

import com.hypers.crius.enhance.AbstractBaseController;
import com.hypers.entity.ProcessedData;
import com.hypers.service.ProcessedDataService;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Lynne
 * @date 2021/12/9
 */

@RestController
@Slf4j
public class DataRepositoryController extends AbstractBaseController<ProcessedData, ProcessedDataService> {


    @PostMapping("/api/repository/import")
    public Object importToRepository(@Valid @RequestBody ProcessedData processedData, BindingResult result){
        return getService().importToRepository(processedData,result);
    }

    @Override
    @GetMapping("/api/repository/records")
    public Object find(ProcessedData processedData){
        log.info("find operation records");
        return super.find(processedData);
    }
}
