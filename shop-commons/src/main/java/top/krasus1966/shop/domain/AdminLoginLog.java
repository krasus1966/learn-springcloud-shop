package top.krasus1966.shop.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Krasus1966
 * @date 2020/7/27 21:08
 **/
@ApiModel(value = "用户登录日志实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@TableName("tb_loginlog")
public class AdminLoginLog implements Serializable {

    private static final long serialVersionUID = 7387140664280560450L;
    @ApiModelProperty(value = "主键id",name = "id")
    @TableId
    private Long id;

    @ApiModelProperty(value = "登录者ip地址",name = "ip")
    @TableField("ip")
    private String ip;

    @ApiModelProperty(value = "登录用户名",name = "username")
    @TableField("no")
    private String username;

    @ApiModelProperty(value = "创建时间",name = "createTime",notes = "使用Mybatis-plus自动填充功能自动填充")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private String createTime;

    @ApiModelProperty(value = "登录地址",name = "location")
    @TableField("location")
    private String location;

}
