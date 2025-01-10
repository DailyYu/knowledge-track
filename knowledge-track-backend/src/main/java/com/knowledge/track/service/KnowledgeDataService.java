package com.knowledge.track.service;

import com.knowledge.track.common.response.ResultResponse;
import com.knowledge.track.domain.dto.KnowledgeDataAddDTO;
import com.knowledge.track.domain.dto.KnowledgeDataListDTO;
import com.knowledge.track.domain.dto.KnowledgeDataUpdateDTO;

public interface KnowledgeDataService {

    /**
     * 分页查询
     * @param dto
     * @return
     */
    ResultResponse list(KnowledgeDataListDTO dto);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    ResultResponse delete(Integer id);


    ResultResponse update(KnowledgeDataUpdateDTO dto);


    ResultResponse add(KnowledgeDataAddDTO dto);

}
