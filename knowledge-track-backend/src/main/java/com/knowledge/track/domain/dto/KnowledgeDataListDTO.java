package com.knowledge.track.domain.dto;

import lombok.Data;

@Data
public class KnowledgeDataListDTO {
    /**
     * 数据集id
     */
    private Integer datasetId;

    private Integer pageNum = 1;

    private Integer pageSize = 20;

}
