package com.hypers.controller;

import com.hypers.crius.enhance.AbstractBaseController;
import com.hypers.entity.RawSource;
import com.hypers.entity.WareHousing;
import com.hypers.entity.enums.Status;
import com.hypers.service.RawSourceService;
import lombok.RequiredArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.*;

/**
 * @author Lynne
 * @date 2021/12/4
 */

@RestController
@RequiredArgsConstructor
public class SpiderController extends AbstractBaseController<RawSource, RawSourceService> {


    @GetMapping("/api/spider")
    public Object start(@Valid @RequestBody RawSource rawSource, BindingResult result) {

        //校验待爬取信息
        if(result.hasErrors()){
            return result;
        }

        //新建文件
        File f = creatFile(rawSource);

        //写入结果
        try (FileOutputStream outputStream = new FileOutputStream(f)) {

            Connection.Response response = Jsoup.connect(rawSource.getUrl()).ignoreContentType(true).execute();
            outputStream.write(response.bodyAsBytes());
            rawSource.setFilePath(f.getAbsolutePath());
            rawSource.setStatus(Status.SUCCEED);

        } catch (IOException e) {

            e.printStackTrace();
            rawSource.setStatus(Status.FAILED);

        }

        //记录爬虫信息
        return super.save(rawSource, result);

    }

    @GetMapping("/api/spider/records")
    public Object spiderRecords(@Valid RawSource rawSource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult;
        }
        return super.find(rawSource);
    }

    @PostMapping("/api/storage")
    public void inbound(@RequestBody WareHousing wareHousing) {
        getService().inbound(wareHousing);
    }

    @GetMapping("/api/storage")
    public Object inboundRecords(WareHousing wareHousing){
        return getService().findInboundRecords(wareHousing);
    }

    public File creatFile(RawSource rawSource) {
        File f = new File(rawSource.getFilePath());
        if (!f.exists()) {
            f.mkdirs();
        }
        return new File(rawSource.getFilePath() + rawSource.getFileName());
    }

}
