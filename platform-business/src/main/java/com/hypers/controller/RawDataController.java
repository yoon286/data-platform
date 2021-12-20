package com.hypers.controller;

import com.hypers.crius.enhance.AbstractBaseController;
import com.hypers.entity.RawData;
import com.hypers.service.RawDataService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Lynne
 * @date 2021/12/8
 */
@RestController
public class RawDataController extends AbstractBaseController<RawData, RawDataService> {

    /**
     * 对元数据进行处理，得到源数据
     * @param rawData 元数据信息
     * @param result 校验信息
     * @return 处理结果
     */
    @PostMapping("/api/raw/data")
    public Object processData(@Valid @RequestBody RawData rawData, BindingResult result){
         if(result.hasErrors()){
             return  result;
         }
        return getService().processData(rawData);

    }

    /**
     * 元数据操作记录
     * @param id 元数据Id
     * @return 所有操作记录
     */
    @GetMapping("/api/meta/data/{id}/operation")
    public Object find(@PathVariable Long id){
        return getService().findById(id);
    }


}
