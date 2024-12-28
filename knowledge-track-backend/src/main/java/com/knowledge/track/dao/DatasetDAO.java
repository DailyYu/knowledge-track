package com.knowledge.track.dao;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.knowledge.track.common.pagination.Page;
import com.knowledge.track.domain.dos.DatasetDO;
import com.knowledge.track.domain.query.DatasetQuery;
import com.knowledge.track.mapper.DatasetMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatasetDAO {

    @Resource
    private DatasetMapper datasetMapper;

    public PageInfo<DatasetDO> selectListByPage(DatasetQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize(), true);
        List<DatasetDO> datasetDOList = datasetMapper.selectList(query);
        return new PageInfo<>(datasetDOList);
    }


}
