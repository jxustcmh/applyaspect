package com.hx.applyaspect.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author minghua.c
 * @date 2019-07-17 16:43
 */
@Data
public class BaseEntity {

    /**
     * 创建人
     */
    private Integer createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdDate;

    /**
     * 更新人
     */
    private Integer updatedBy;

    /**
     * 更新时间
     */
    private LocalDateTime updatedDate;

}
