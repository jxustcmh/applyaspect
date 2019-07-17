package com.hx.applyaspect.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author minghua.c
 * @date 2019-07-17 18:29
 */
@Data
@ApiModel
public class UserDTO {
    @ApiModelProperty("用户ID")
    @NotBlank(message = "用户ID不能为空")
    @Length(max = 32, min = 32, message = "非法的用户ID")
    private String userId;

    @ApiModelProperty("用户名称")
    @NotBlank(message = "用户名称不能为空")
    @Length(max = 30, message = "用户名称长度最大不能超过30个字符")
    private String userName;
}
