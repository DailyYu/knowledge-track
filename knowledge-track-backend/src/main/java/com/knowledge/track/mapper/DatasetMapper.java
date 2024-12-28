package com.knowledge.track.mapper;

import com.knowledge.track.domain.dos.DatasetDO;
import com.knowledge.track.domain.query.DatasetQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface DatasetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DatasetDO record);

    int insertSelective(DatasetDO record);

    DatasetDO selectByPrimaryKey(Integer id);

    List<DatasetDO> selectList(DatasetQuery query);


    int updateByPrimaryKeySelective(DatasetDO record);

    int updateByPrimaryKey(DatasetDO record);
}