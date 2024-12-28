package com.knowledge.track.domain.dos;

import lombok.Data;
import java.util.Date;

@Data
public class KnowledgeDataDO {
    private Integer id;

    private Integer datasetId;

    private String groupName;

    private String title;

    private Integer difficulty;

    private Integer masterLevel;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private String content;
}