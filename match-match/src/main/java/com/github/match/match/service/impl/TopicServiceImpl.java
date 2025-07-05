package com.github.match.match.service.impl;

import java.util.List;

import com.github.match.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.match.match.mapper.TopicMapper;
import com.github.match.match.domain.Topic;
import com.github.match.match.service.ITopicService;

/**
 * 搭子模块Service业务层处理
 *
 * @author haipeng-lin
 * @date 2025-07-05
 */
@Service
public class TopicServiceImpl implements ITopicService {
    @Autowired
    private TopicMapper topicMapper;

    /**
     * 查询搭子模块
     *
     * @param id 搭子模块主键
     * @return 搭子模块
     */
    @Override
    public Topic selectTopicById(String id) {
        return topicMapper.selectTopicById(id);
    }

    /**
     * 查询搭子模块列表
     *
     * @param topic 搭子模块
     * @return 搭子模块
     */
    @Override
    public List<Topic> selectTopicList(Topic topic) {
        return topicMapper.selectTopicList(topic);
    }

    /**
     * 新增搭子模块
     *
     * @param topic 搭子模块
     * @return 结果
     */
    @Override
    public int insertTopic(Topic topic) {
        topic.setCreateTime(DateUtils.getNowDate());
        return topicMapper.insertTopic(topic);
    }

    /**
     * 修改搭子模块
     *
     * @param topic 搭子模块
     * @return 结果
     */
    @Override
    public int updateTopic(Topic topic) {
        topic.setUpdateTime(DateUtils.getNowDate());
        return topicMapper.updateTopic(topic);
    }

    /**
     * 批量删除搭子模块
     *
     * @param ids 需要删除的搭子模块主键
     * @return 结果
     */
    @Override
    public int deleteTopicByIds(String[] ids) {
        return topicMapper.deleteTopicByIds(ids);
    }

    /**
     * 删除搭子模块信息
     *
     * @param id 搭子模块主键
     * @return 结果
     */
    @Override
    public int deleteTopicById(String id) {
        return topicMapper.deleteTopicById(id);
    }
}
