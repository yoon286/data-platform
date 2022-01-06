package com.hypers.service.impl;

import cn.hutool.db.Db;
import com.hypers.crius.enhance.AbstractBaseService;
import com.hypers.dao.RawDataDao;
import com.hypers.entity.RawData;
import com.hypers.service.MetaDataService;
import com.hypers.service.RawDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Lynne
 * @date 2021/12/8
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RawDataServiceImpl extends AbstractBaseService<RawData, RawDataDao> implements RawDataService {

    private final MetaDataService metaDataService;

    @Override
    public Object processData(RawData rawData) {

        Object result = null;
        Long metaDataId = rawData.getMetaData().getMetaDataId();
        String dataBase = metaDataService.findOne(metaDataId).orElseThrow(NullPointerException::new).getDataBase();

        try {
            switch (rawData.getOperation()) {
                case INSERT:
                case UPDATE:
                case DELETE:
                    result = Db.use(dataBase).execute(rawData.getSql());
                    break;
                case SELECT:
                    result = Db.use(dataBase).query(rawData.getSql());
                    break;
                default:
                    break;
            }
            getDao().save(rawData);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        log.info("process data completed......");

        return result;


    }

    @Override
    public List<RawData> findById(Long id) {
        return getDao().findById(id);
    }

}
