package top.krasus1966.shop.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static io.swagger.annotations.ApiModelProperty.AccessMode.READ_ONLY;

/**
 * 管理员DO
 * @author Krasus1966
 * @date 2020/7/22 21:53
 **/
@ApiModel(description = "管理员实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("tb_admin")
public class Admin extends Model<Admin> implements Serializable {

    private static final long serialVersionUID = 1927764030207768699L;
    @ApiModelProperty("用户id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户名")
    @TableField
    private String username;

    @ApiModelProperty(value = "密码", notes = "默认不会被查询")
    @TableField(select = false)
    private String password;

    @ApiModelProperty("用户状态")
    @TableField
    private Integer status;

    @ApiModelProperty("用户照片")
    @TableField
    private String photo;

    @ApiModelProperty(accessMode = READ_ONLY)
    @TableLogic
    @TableField(select = false)
    @JsonIgnore
    private Integer del;
}
