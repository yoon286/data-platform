package com.hypers.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.util.StrUtil;
import com.hypers.crius.enhance.AbstractBaseService;
import com.hypers.dao.RawSourceDao;
import com.hypers.entity.MetaData;
import com.hypers.entity.RawSource;
import com.hypers.entity.WareHousing;
import com.hypers.service.MetaDataService;
import com.hypers.service.RawSourceService;
import io.netty.util.internal.StringUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Lynne
 * @date 2021/12/7
 */

@Service
@RequiredArgsConstructor
public class RawSourceServiceImpl extends AbstractBaseService<RawSource, RawSourceDao> implements RawSourceService {

    private final MetaDataService metaDataService;

    @Override
    public void inbound(WareHousing wareHousing) {
        //设置文件路径
        RawSource source = getDao().findOne(wareHousing.getRawSource().getId());
        wareHousing.setFile(StrUtil.replace(source.getFilePath(), "\\", "\\\\"));

        //读取CSV文件表头
        CsvReader reader = CsvUtil.getReader();
        CsvData data = reader.read(FileUtil.file(wareHousing.getFile()));
        List<String> header = data.getRow(0).stream().map(x ->
                     StringUtils.replacePattern(StringUtils.trim(x)," ","_")
        ).collect(Collectors.toList());
        wareHousing.setHeader(header);

        //入库
        getDao().inbound(wareHousing);
        getDao().saveInboundRecords(wareHousing);

        MetaData metaData = new MetaData();
        metaData.setRawSource(wareHousing.getRawSource());
        metaData.setTableName(wareHousing.getTableName());
        metaData.setDataBase(wareHousing.getDataBase());
        metaData.setRow(data.getRowCount() - 1);
        metaData.setColumn(header.size());
        metaDataService.save(metaData);
    }

    @Override
    public List<WareHousing> findInboundRecords(WareHousing wareHousing) {
        return getDao().findInboundRecords(wareHousing);
    }

    @Override
    public void saveInboundRecords(WareHousing wareHousing) {
        getDao().saveInboundRecords(wareHousing);
    }

}
