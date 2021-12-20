package com.hypers.controller;

import com.hypers.crius.enhance.AbstractBaseController;
import com.hypers.entity.MetaData;
import com.hypers.service.MetaDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lynne
 * @date 2021/12/5
 */

@RestController
public class MetaDataController extends AbstractBaseController<MetaData, MetaDataService> {


    @Override
    @GetMapping("/api/metadata")
    public Object find(MetaData metaData){
        return super.find(metaData);
    }


}
