package com.knowledge.track.converter;


import com.knowledge.track.domain.dos.DatasetDO;
import com.knowledge.track.domain.vo.DatasetVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DatasetConverter {


    List<DatasetVO> datasetDO2VO(List<DatasetDO> datasetDOList);

}
