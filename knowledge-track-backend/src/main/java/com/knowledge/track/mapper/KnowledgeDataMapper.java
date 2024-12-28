package com.knowledge.track.mapper;



import com.knowledge.track.domain.dos.KnowledgeDataDO;
import com.knowledge.track.domain.query.KnowledgeDataQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KnowledgeDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KnowledgeDataDO record);

    int insertSelective(KnowledgeDataDO record);

    KnowledgeDataDO selectByPrimaryKey(Integer id);

    List<KnowledgeDataDO> selectList(KnowledgeDataQuery query);

    int updateByPrimaryKeySelective(KnowledgeDataDO record);

    int updateByPrimaryKeyWithBLOBs(KnowledgeDataDO record);

    int updateByPrimaryKey(KnowledgeDataDO record);
}