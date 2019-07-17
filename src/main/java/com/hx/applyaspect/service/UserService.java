package com.hx.applyaspect.service;

import com.hx.applyaspect.dto.UserDTO;

/**
 * @author minghua.c
 * @date 2019-07-17 18:27
 */
public interface UserService {
    /**
     *  添加用户
     *
     * @param userDTO 用户信息
     *
     */
    void add(UserDTO userDTO);
}
