package com.knowledge.track.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class KnowledgeDataUpdateDTO {

    @NotNull(message = "数据主键不能为空")
    private Integer id;

    private String groupName;

    private String title;

    private Integer difficulty;

    private Integer masterLevel;

    private Date updatedAt;

    private String content;

}
