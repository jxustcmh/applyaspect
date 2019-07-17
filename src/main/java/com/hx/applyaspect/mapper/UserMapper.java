package com.hx.applyaspect.mapper;

import com.hx.applyaspect.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author minghua.c
 * @date 2019-07-17 16:40
 */
@Repository
public interface UserMapper {
    /**
     *  保存一个用户
     * @param user 用户模型
     */

    void saveOne(User user);
}
