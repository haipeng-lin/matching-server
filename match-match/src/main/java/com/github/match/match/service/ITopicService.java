package com.github.match.match.service;

import java.util.List;

import com.github.match.match.domain .Topic;

/**
 * 搭子模块Service接口
 *
 * @author haipeng-lin
 * @date 2025-07-05
 */
public interface ITopicService {
    /**
     * 查询搭子模块
     *
     * @param id 搭子模块主键
     * @return 搭子模块
     */
    public Topic selectTopicById(String id);

    /**
     * 查询搭子模块列表
     *
     * @param topic 搭子模块
     * @return 搭子模块集合
     */
    public List<Topic> selectTopicList(Topic topic);

    /**
     * 新增搭子模块
     *
     * @param topic 搭子模块
     * @return 结果
     */
    public int insertTopic(Topic topic);

    /**
     * 修改搭子模块
     *
     * @param topic 搭子模块
     * @return 结果
     */
    public int updateTopic(Topic topic);

    /**
     * 批量删除搭子模块
     *
     * @param ids 需要删除的搭子模块主键集合
     * @return 结果
     */
    public int deleteTopicByIds(String[] ids);

    /**
     * 删除搭子模块信息
     *
     * @param id 搭子模块主键
     * @return 结果
     */
    public int deleteTopicById(String id);
}
