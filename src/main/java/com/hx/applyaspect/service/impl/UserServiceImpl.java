package com.hx.applyaspect.service.impl;

import com.hx.applyaspect.dto.UserDTO;
import com.hx.applyaspect.mapper.UserMapper;
import com.hx.applyaspect.model.User;
import com.hx.applyaspect.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author minghua.c
 * @date 2019-07-17 18:28
 */
@Service
public class UserServiceImpl  implements UserService {

    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void add(UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setUserName(userDTO.getUserName());
        user.setCreatedBy(199);
        userMapper.saveOne(user);
    }
}
