package com.knowledge.track.service.impl;

import com.github.pagehelper.PageInfo;
import com.knowledge.track.common.pagination.Page;
import com.knowledge.track.common.response.ResultResponse;
import com.knowledge.track.converter.KnowledgeDataConverter;
import com.knowledge.track.dao.KnowledgeDataDAO;
import com.knowledge.track.domain.dos.KnowledgeDataDO;
import com.knowledge.track.domain.dto.KnowledgeDataListDTO;
import com.knowledge.track.domain.dto.KnowledgeDataUpdateDTO;
import com.knowledge.track.domain.query.KnowledgeDataQuery;
import com.knowledge.track.service.KnowledgeDataService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class KnowledgeDataServiceImpl implements KnowledgeDataService {


    @Resource
    private KnowledgeDataDAO knowledgeDataDAO;

    @Resource
    private KnowledgeDataConverter knowledgeDataConverter;

    @Override
    public ResultResponse list(KnowledgeDataListDTO dto) {
        KnowledgeDataQuery query = new KnowledgeDataQuery();
        query.setPageNum(dto.getPageNum());
        query.setPageSize(dto.getPageSize());
        PageInfo<KnowledgeDataDO> result = knowledgeDataDAO.selectListByPage(query);
        return ResultResponse.success(new Page<>(result.getTotal(), knowledgeDataConverter.knowledgeDO2VO(result.getList())));
    }


    @Override
    public ResultResponse delete(Integer id) {
        knowledgeDataDAO.deleteById(id);
        return ResultResponse.success(null);
    }


    @Override
    public ResultResponse update(KnowledgeDataUpdateDTO dto) {
        KnowledgeDataDO knowledgeDataDO = knowledgeDataConverter.knowledgeUpdateDto2Do(dto);
        knowledgeDataDAO.updateById(knowledgeDataDO);
        return ResultResponse.success(null);
    }
}
