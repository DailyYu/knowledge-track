package com.knowledge.track.converter;

import com.knowledge.track.domain.dos.KnowledgeDataDO;
import com.knowledge.track.domain.dto.KnowledgeDataAddDTO;
import com.knowledge.track.domain.dto.KnowledgeDataUpdateDTO;
import com.knowledge.track.domain.vo.KnowledgeDataVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KnowledgeDataConverter {

    List<KnowledgeDataVO> knowledgeDO2VO(List<KnowledgeDataDO> knowledgeDataDOList);


    KnowledgeDataDO knowledgeUpdateDto2Do(KnowledgeDataUpdateDTO dto);

    KnowledgeDataDO knowledgeAddDto2Do(KnowledgeDataAddDTO dto);

}
