package com.knowledge.track.domain.dos;

import lombok.Data;
import java.util.Date;

@Data
public class DatasetDO {
    private Integer id;

    private String name;

    private String description;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

}