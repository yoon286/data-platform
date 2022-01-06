package com.hypers.controller;

import com.hypers.crius.enhance.AbstractBaseController;
import com.hypers.entity.MetaData;
import com.hypers.service.MetaDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lynne
 * @date 2021/12/5
 */

@RestController
@Slf4j
public class MetaDataController extends AbstractBaseController<MetaData, MetaDataService> {


    @Override
    @GetMapping("/api/metadata")
    public Object find(MetaData metaData){
        log.info("find meta data info...");
        return super.find(metaData);
    }


}
