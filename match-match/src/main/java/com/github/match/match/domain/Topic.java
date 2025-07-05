package com.github.match.match.domain;

import com.github.match.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.github.match.common.annotation.Excel;

/**
 * 搭子模块对象 mat_topic
 *
 * @author haipeng-lin
 * @date 2025-07-05
 */
public class Topic extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 主题名称
     */
    @Excel(name = "主题名称")
    private String name;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
