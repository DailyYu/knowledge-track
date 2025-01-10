package com.knowledge.track.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.knowledge.track.domain.dos.DatasetDO;
import com.knowledge.track.domain.dos.KnowledgeDataDO;
import com.knowledge.track.domain.query.KnowledgeDataQuery;
import com.knowledge.track.mapper.KnowledgeDataMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class KnowledgeDataDAO {

    @Resource
    private KnowledgeDataMapper knowledgeDataMapper;

    public PageInfo<KnowledgeDataDO> selectListByPage(KnowledgeDataQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize(), true);
        List<KnowledgeDataDO> result = knowledgeDataMapper.selectList(query);
        return new PageInfo<>(result);
    }


    public void deleteById(Integer id) {
        KnowledgeDataDO knowledgeDataDO = knowledgeDataMapper.selectByPrimaryKey(id);
        knowledgeDataDO.setDeletedAt(new Date());
        knowledgeDataMapper.updateByPrimaryKeySelective(knowledgeDataDO);
    }


    public void updateById(KnowledgeDataDO knowledgeDataDO) {
        knowledgeDataDO.setUpdatedAt(new Date());
        knowledgeDataMapper.updateByPrimaryKeySelective(knowledgeDataDO);
    }

    public void add(KnowledgeDataDO knowledgeDataDO) {
        knowledgeDataDO.setCreatedAt(new Date());
        knowledgeDataMapper.insertSelective(knowledgeDataDO);
    }




}
