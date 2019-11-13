package org.volans.scheduler.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author j
 * @since 2019-11-12
 */
public class JobInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * corn 表达式
     */
    private String corn;
    /**
     * 任务名称
     */
    private String name;

    /**
     * 任务状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Long createdAt;
    /**
     * 上次执行时间
     */
    private Long lastExcutedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorn() {
        return corn;
    }

    public void setCorn(String corn) {
        this.corn = corn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getLastExcutedAt() {
        return lastExcutedAt;
    }

    public void setLastExcutedAt(Long lastExcutedAt) {
        this.lastExcutedAt = lastExcutedAt;
    }

    @Override
    public String toString() {
        return "JobInfo{" +
        ", id=" + id +
        ", corn=" + corn +
        ", name=" + name +
        ", status=" + status +
        ", createdAt=" + createdAt +
        ", lastExcutedAt=" + lastExcutedAt +
        "}";
    }
}
