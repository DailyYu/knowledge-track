package com.knowledge.track.domain.vo;

import lombok.Data;

import java.util.Date;


@Data
public class DatasetVO {

    private Integer id;

    private String name;

    private String description;

    private Date createdAt;

    private Date updatedAt;

}
