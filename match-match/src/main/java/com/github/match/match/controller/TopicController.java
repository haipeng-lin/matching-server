package com.github.match.match.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.match.common.annotation.Log;
import com.github.match.common.core.controller.BaseController;
import com.github.match.common.core.domain.AjaxResult;
import com.github.match.common.enums.BusinessType;
import com.github.match.match.domain.Topic;
import com.github.match.match.service.ITopicService;
import com.github.match.common.utils.poi.ExcelUtil;
import com.github.match.common.core.page.TableDataInfo;

/**
 * 搭子模块Controller
 *
 * @author haipeng-lin
 * @date 2025-07-05
 */
@RestController
@RequestMapping("/match/topic")
public class TopicController extends BaseController {
    @Autowired
    private ITopicService topicService;

/**
 * 查询搭子模块列表
 */
@PreAuthorize("@ss.hasPermi('match:topic:list')")
@GetMapping("/list")
    public TableDataInfo list(Topic topic) {
        startPage();
        List<Topic> list = topicService.selectTopicList(topic);
        return getDataTable(list);
    }

    /**
     * 导出搭子模块列表
     */
    @PreAuthorize("@ss.hasPermi('match:topic:export')")
    @Log(title = "搭子模块", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Topic topic) {
        List<Topic> list = topicService.selectTopicList(topic);
        ExcelUtil<Topic> util = new ExcelUtil<Topic>(Topic. class);
        util.exportExcel(response, list, "搭子模块数据");
    }

    /**
     * 获取搭子模块详细信息
     */
    @PreAuthorize("@ss.hasPermi('match:topic:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return success(topicService.selectTopicById(id));
    }

    /**
     * 新增搭子模块
     */
    @PreAuthorize("@ss.hasPermi('match:topic:add')")
    @Log(title = "搭子模块", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Topic topic) {
        topic.setCreateBy(getUsername());
        return toAjax(topicService.insertTopic(topic));
    }

    /**
     * 修改搭子模块
     */
    @PreAuthorize("@ss.hasPermi('match:topic:edit')")
    @Log(title = "搭子模块", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Topic topic) {
        topic.setUpdateBy(getUsername());
        return toAjax(topicService.updateTopic(topic));
    }

    /**
     * 删除搭子模块
     */
    @PreAuthorize("@ss.hasPermi('match:topic:remove')")
    @Log(title = "搭子模块", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(topicService.deleteTopicByIds(ids));
    }
}
