package com.knowledge.track.domain.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class KnowledgeDataAddDTO {


    @NotNull(message = "数据集id不能为空")
    private Integer datasetId;

    private String groupName;

    private String title;

    private Integer difficulty;

    private Integer masterLevel;

    private String content;


}
