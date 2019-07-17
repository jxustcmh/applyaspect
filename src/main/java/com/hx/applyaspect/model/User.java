package com.hx.applyaspect.model;

import lombok.Data;

/**
 * @author minghua.c
 * @date 2019-07-17 16:39
 */
@Data
public class User extends BaseEntity {
    /**
     *  id编号
     */
    private String userId;

    /**
     *  姓名
     */
    private String userName;

}
