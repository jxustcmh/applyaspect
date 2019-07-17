package com.hx.applyaspect.web;

import com.hx.applyaspect.dto.UserDTO;
import com.hx.applyaspect.model.MyResponse;
import com.hx.applyaspect.service.UserService;
import com.sigma.sigmacore.web.SigmaPagingResponse;
import com.sigma.sigmacore.web.SigmaRequest;
import com.sigma.sigmacore.web.SigmaResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author minghua.c
 * @date 2019-07-17 18:36
 */
@RestController
@Api(value = "用户控制器")
@RequestMapping(value = "/api/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*******************************
     *    添加
     *******************************/
    @ApiOperation("保存一个课程")
    @PostMapping("/add")
    public SigmaResponse<String> saveOne(@RequestBody SigmaRequest<UserDTO> request) {
         userService.add(request.getData());
         return new SigmaResponse("ok");
    }

}
