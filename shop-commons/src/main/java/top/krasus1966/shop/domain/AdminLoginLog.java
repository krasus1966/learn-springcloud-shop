package top.krasus1966.shop.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Krasus1966
 * @date 2020/7/27 21:08
 **/
@ApiModel(description = "用户登录日志实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("tb_loginlog")
public class AdminLoginLog extends Model<AdminLoginLog> implements Serializable {

    private static final long serialVersionUID = 7387140664280560450L;
    @ApiModelProperty(value = "主键id",name = "id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "登录者ip地址",name = "ip")
    @TableField("ip")
    private String ip;

    @ApiModelProperty(value = "登录用户名",name = "username")
    @TableField("no")
    private String username;

    @ApiModelProperty(value = "创建时间",name = "createTime",notes = "使用Mybatis-plus自动填充功能自动填充")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "登录地址",name = "location")
    @TableField("location")
    private String location;

}
