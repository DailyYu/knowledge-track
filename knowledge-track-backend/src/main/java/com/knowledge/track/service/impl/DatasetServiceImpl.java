package com.knowledge.track.service.impl;

import com.github.pagehelper.PageInfo;
import com.knowledge.track.common.pagination.Page;
import com.knowledge.track.common.response.ResultResponse;
import com.knowledge.track.converter.DatasetConverter;
import com.knowledge.track.dao.DatasetDAO;
import com.knowledge.track.domain.dos.DatasetDO;
import com.knowledge.track.domain.dto.DatasetListDTO;
import com.knowledge.track.domain.query.DatasetQuery;
import com.knowledge.track.service.DatasetService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class DatasetServiceImpl implements DatasetService {

    @Resource
    private DatasetDAO datasetDAO;

    @Resource
    private DatasetConverter datasetConverter;

    @Override
    public ResultResponse list(DatasetListDTO dto) {
        DatasetQuery query = new DatasetQuery();
        query.setPageNum(dto.getPageNum());
        query.setPageSize(dto.getPageSize());
        PageInfo<DatasetDO> result = datasetDAO.selectListByPage(query);
        return ResultResponse.success(new Page<>(result.getTotal(), datasetConverter.datasetDO2VO(result.getList())));
    }
}
