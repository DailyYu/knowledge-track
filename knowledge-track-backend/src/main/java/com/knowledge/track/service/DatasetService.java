package com.knowledge.track.service;

import com.knowledge.track.common.response.ResultResponse;
import com.knowledge.track.domain.dto.DatasetListDTO;

public interface DatasetService {

    ResultResponse list(DatasetListDTO dto);

}
